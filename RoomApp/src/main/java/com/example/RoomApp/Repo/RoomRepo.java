package com.example.RoomApp.Repo;

import com.example.RoomApp.Model.RoomApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepo extends CrudRepository<RoomApp,Integer> {



    List<RoomApp> findByRoomPrice(double p);
}
