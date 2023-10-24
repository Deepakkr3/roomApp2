package com.example.RoomApp.Controller;

import com.example.RoomApp.Model.RoomApp;
import com.example.RoomApp.Services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired

    Service   roomService;
    @PostMapping("room")
    public  String addRoom(@RequestBody RoomApp   newRoom){
         return roomService.addRoom(newRoom);
    }

//    public String addRooms(@RequestBody RoomApp newRooms){
//        return roomService.addrooms(newRooms);
//    }

    @GetMapping("rooms")
    public List<RoomApp> getAll(){
        return roomService.getAll();
    }
    @PutMapping("update/id/{id}")
    public String update(@PathVariable Integer id, @RequestParam Integer roomNumber){
         return roomService.update(id,roomNumber);
    }
   @DeleteMapping("delete/{id}")
    public String DeleteNumber(@PathVariable Integer id){
        return roomService.DeleteNumber(id);
    }
     //add multiplr room at onece
    @PostMapping("rooms")
    public String addroms(@RequestBody List<RoomApp> myroom)
    {
        return roomService.addroms(myroom);
    }

    // get bu id
    @GetMapping("get/by/{id}/id")
    public RoomApp getbyid(@PathVariable Integer id)
    {
        return roomService.getbuid(id);
    }
    // delete by ids
    @DeleteMapping("room/belete/id")
    public String del(@RequestBody List<Integer> id)
    {
        return  roomService.del(id);
    }
    //get room by price
    @GetMapping("price/{price}/")



    public List<RoomApp> getbyprice(@PathVariable double p)
    {
        return roomService.getbyprice(p);
    }


    @GetMapping("test")
    public String testmap(){
        return "hellow testing";
    }


}
