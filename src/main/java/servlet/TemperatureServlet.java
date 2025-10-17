package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet("/Temperature")
public class TemperatureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TemperatureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String temperature_input_str = request.getParameter("temperature_input");
		String temperature_unit_from = request.getParameter("temperature_unit_from");
		String temperature_unit_to = request.getParameter("temperature_unit_to");
		
		BigDecimal temperatureAmount = new BigDecimal(temperature_input_str);
		BigDecimal temperatureResult = new BigDecimal(0);
		String temperatureResultStr="";
		String temperatureAmountStr="";
		
		switch (temperature_unit_from.trim()) {
			case "fahrenheit" :
				switch (temperature_unit_to) {
				case "fahrenheit" :
					temperatureResult = temperatureAmount.multiply(new BigDecimal(1));
					break;
				case "celsius" :
					temperatureResult = (temperatureAmount.subtract(new BigDecimal(32)))
							.multiply(new BigDecimal(5).divide(new BigDecimal(9), 4, RoundingMode.HALF_UP));
					break;
				case "kelvin" :
					temperatureResult = (temperatureAmount.subtract(new BigDecimal(32)))
							.multiply(new BigDecimal(5).divide(new BigDecimal(9), 4, RoundingMode.HALF_UP))
									.add(new BigDecimal(273.15));
					break;
				}
				break;
				
			case "celsius" :
				switch (temperature_unit_to) {
				case "fahrenheit" :
					temperatureResult = (temperatureAmount.subtract(new BigDecimal(32)))
					.multiply(new BigDecimal(5).divide(new BigDecimal(9), 4, RoundingMode.HALF_UP))
					.multiply(new BigDecimal(-1));
					break;
				case "celsius" :
					temperatureResult = temperatureAmount.multiply(new BigDecimal(1));
					break;
				case "kelvin" :
					temperatureResult = (temperatureAmount.add(new BigDecimal(273.15)));
					break;
				}
				break;
				
			case "kelvin" :
				switch (temperature_unit_to) {
				case "fahrenheit" :
					temperatureResult = (temperatureAmount.subtract(new BigDecimal(32)))
					.multiply(new BigDecimal(5).divide(new BigDecimal(9), 4, RoundingMode.HALF_UP))
							.add(new BigDecimal(273.15)).multiply(new BigDecimal(-1));
					break;
				case "celsius" :
					temperatureResult = (temperatureAmount.subtract(new BigDecimal(273.15)));
					break;
				case "kelvin" :
					temperatureResult = temperatureAmount.multiply(new BigDecimal(1));
					break;
				}
				break;
				
		}
		
		temperatureResultStr = String.valueOf(temperatureResult);
		temperatureAmountStr = String.valueOf(temperatureAmount);
		
        // Set data as an attribute in the request
		request.setAttribute("input", temperatureAmountStr);
        request.setAttribute("result", temperatureResultStr);
        request.setAttribute("unit_from", temperature_unit_from);
        request.setAttribute("unit_to", temperature_unit_to);
        
        // Dispatch the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/index.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
