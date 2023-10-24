package com.example.RoomApp.Services;

import com.example.RoomApp.Model.RoomApp;
import com.example.RoomApp.Repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
  @Autowired
  RoomRepo roomRepo;

  public String addRoom(RoomApp newRoom) {
    roomRepo.save(newRoom);
    return "Add h2 post data";
  }


  public List<RoomApp> getAll() {

    //  return (List<RoomApp>) roomRepo.findAll();
    return (List<RoomApp>) roomRepo.findAll();
  }


  public  String update(Integer id, Integer roomNumber) {
    RoomApp roomUpdate = roomRepo.findById(id).orElse(null);
    if (roomUpdate != null) {
      roomUpdate.setRoomNumber(roomNumber);
      roomRepo.save(roomUpdate);
      return "Room updated successfully";
      }

    return "Room not found";
    }
  public String DeleteNumber(Integer id) {
    Optional<RoomApp> roomToDelete = roomRepo.findById(id);
    if (roomToDelete.isPresent()) {
      roomRepo.deleteById(id);
      return "Room with ID " + id + " deleted successfully";
    } else {
      return "Room with ID " + id + " not found";
      }
  }

  public String addroms(List<RoomApp> myroom) {
     roomRepo.saveAll(myroom);
     return "rooms has been added";
  }

  public RoomApp getbuid(Integer id) {
    return roomRepo.findById(id).get();
  }

  public String del(List<Integer> id) {
      roomRepo.deleteAllById(id);
      return " rooms deleted";
  }

  public List<RoomApp> getbyprice(double p) {
    return roomRepo.findByRoomPrice(p);
  }
}
