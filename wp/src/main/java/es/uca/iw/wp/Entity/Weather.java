package es.uca.iw.wp.Entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
public class Weather 
{
	@GeneratedValue
	@Id
	private Long id;
	private double _dTemperature, _dPressure;
	private String _sDescription;
	
	@OneToOne
	private City _oCity;
	
	public Weather() {}
	
	/**
	 * 
	 * @param dTemperature
	 * @param dPressure
	 * @param sDescription
	 */
	public Weather(double dTemperature, double dPressure, String sDescription)
	{
		_dTemperature = dTemperature;
		_dPressure = dPressure;
		_sDescription = sDescription;
	}
	
	public double getTemperature() { return _dTemperature; }
	
	private String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
	
	public Weather getCurrentWeather(double dLat, double dLong) throws Exception
	{
		
		//API Key b6decc5482ae5bdfffd348ebce21175f
		//String url provincias de españa
        String sUrl = "http://api.openweathermap.org/data/2.5/weather?"
        		+ "lat=" + dLat + "&lon=" + dLong + "";
        
        String sResponse = "";

        //Pasamos la URL del objeto a consultar
        URL url = new URL(sUrl);
        HttpURLConnection oConn = (HttpURLConnection) url.openConnection();
        oConn.setRequestMethod("GET");

        // Leemos lo devuelto
        InputStream in = new BufferedInputStream(oConn.getInputStream());

        sResponse = convertStreamToString(in);
        
        Weather oWeather = null;
        
        if(sResponse != null)
        {
        	if(sResponse != null)
            {

                //Obtenemos el nodo del array JSON
                JSONArray oJSONArray = new JSONArray(sResponse);

                //recorremos el archivo JSON
                for (int i = 0; i < oJSONArray.length(); i++)
                {
                    JSONObject oObjetoActual = oJSONArray.getJSONObject(i);

                    //Obtenemos los dos campos.
                    int iId_provincia = oObjetoActual.getInt("id");
                    String sName = oObjetoActual.getString("name");

                }
            }
        	return null;
        }
		return oWeather;
	}
}