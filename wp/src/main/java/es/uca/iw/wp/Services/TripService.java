package es.uca.iw.wp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uca.iw.wp.Repository.TripRepository;

@Service
public class TripService {
	
	
	private TripRepository _oTripRep;
	
	@Autowired
	public TripService(TripRepository oTripRepository)
	{
		_oTripRep = oTripRepository;
	}
}
