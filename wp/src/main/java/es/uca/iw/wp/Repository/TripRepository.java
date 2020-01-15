package es.uca.iw.wp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.wp.Entity.Trip;


public interface TripRepository extends JpaRepository<Trip, String>{

}
