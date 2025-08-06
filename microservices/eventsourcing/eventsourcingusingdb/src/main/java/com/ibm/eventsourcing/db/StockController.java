package com.ibm.eventsourcing.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StockController {
    @Autowired
    private EventService eventService;
    @Autowired
    private StockRepository stockRepository;

    @PostMapping("/stock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stockRequest) throws JsonProcessingException {
        StockAddedEvent addedEvent = StockAddedEvent.builder().stockDetails(stockRequest).build();
        StockUpdatedEvent updatedEvent = StockUpdatedEvent.builder().stockDetails(stockRequest).build();
        List<Stock> existingStockList = stockRepository.findByName(stockRequest.getName());
        if (existingStockList != null && existingStockList.size() > 0) {
            Stock existingStock = existingStockList.get(0);
            int newQuantity = existingStock.getQuantity() + stockRequest.getQuantity();
            //update logic
            existingStock.setQuantity(newQuantity);
            existingStock.setName(stockRequest.getName());
            updatedEvent.setStockDetails(existingStock);
            //fire update event
            eventService.addEvent(updatedEvent);
            return ResponseEntity.ok(existingStock); // 200 OK
        } else {
            stockRepository.save(stockRequest);
            eventService.addEvent(addedEvent);
            return ResponseEntity.status(201).body(stockRequest); // 201 Created
        }
    }

    @DeleteMapping("/stock")
    public void removeStock(@RequestBody Stock stock) throws JsonProcessingException {
        StockRemovedEvent event = StockRemovedEvent.builder().stockDetails(stock).build();
        int newQuantity = 0;
        List<Stock> existingStockList = stockRepository.findByName(stock.getName());
        if (existingStockList != null && existingStockList.size() > 0) {

            Stock existingStock = existingStockList.get(0);
            newQuantity = existingStock.getQuantity() - stock.getQuantity();
            if (newQuantity <= 0) {
                stockRepository.delete(existingStock);
            } else {
                System.out.println(newQuantity);
                existingStock.setQuantity(newQuantity);
                existingStock.setUser(stock.getUser());
                stockRepository.save(existingStock);
            }
            event.setStockDetails(existingStock);
        }

        eventService.addEvent(event);
    }

    @GetMapping("/stock")
    public Stock getStock(@RequestParam("name") String name) throws JsonProcessingException {
        Iterable<EventStore> events = eventService.fetchAllEvents(name);
        Stock currentStock = new Stock();
        currentStock.setName(name);
        currentStock.setUser("NA");
        for (EventStore event : events) {
            Stock stock = new Gson().fromJson(event.getEventData(), Stock.class);
            if (event.getEventType().equals("STOCK_ADDED")) {
                currentStock.setQuantity(currentStock.getQuantity() + stock.getQuantity());
            } else if (event.getEventType().equals("STOCK_REMOVED")) {
                currentStock.setQuantity(currentStock.getQuantity() - stock.getQuantity());
            }
        }
        return currentStock;
    }

    @GetMapping("/events")
    public Iterable<EventStore> getEvents(@RequestParam("name") String name) throws JsonProcessingException {
        Iterable<EventStore> events = eventService.fetchAllEvents(name);
        return events;
    }

    //History of events.
    @GetMapping("/stock/history")
    public Stock getStockUntilDate(@RequestParam("date") String date, @RequestParam("name") String name) throws JsonProcessingException {

        String[] dateArray = date.split("-");

        LocalDateTime dateTill = LocalDate.of(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2])).atTime(23, 59);


        Iterable<EventStore> events = eventService.fetchAllEventsTillDate(name, dateTill);

        Stock currentStock = new Stock();

        currentStock.setName(name);
        currentStock.setUser("NA");

        for (EventStore event : events) {

            Stock stock = new Gson().fromJson(event.getEventData(), Stock.class);

            if (event.getEventType().equals("STOCK_ADDED")) {

                currentStock.setQuantity(currentStock.getQuantity() + stock.getQuantity());
            } else if (event.getEventType().equals("STOCK_REMOVED")) {

                currentStock.setQuantity(currentStock.getQuantity() - stock.getQuantity());
            }
        }

        return currentStock;

    }


}