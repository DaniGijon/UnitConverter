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

@WebServlet("/Length")
public class LengthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LengthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String length_input_str = request.getParameter("length_input");
		String length_unit_from = request.getParameter("length_unit_from");
		String length_unit_to = request.getParameter("length_unit_to");
		
		BigDecimal lengthAmount = new BigDecimal(length_input_str);
		BigDecimal lengthResult = new BigDecimal(0);
		String lengthResultStr = "";
		String lengthAmountStr = "";
		
		switch (length_unit_from.trim()) {
			case "milimeters":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "centimeters":
						lengthResult = lengthAmount.divide(new BigDecimal(10));
						break;
					case "meters":
						lengthResult = lengthAmount.divide(new BigDecimal(1000));
						break;
					case "kilometers":
						lengthResult = lengthAmount.divide(new BigDecimal(1000000));
						break;
					case "inches":
						lengthResult = lengthAmount.divide(new BigDecimal(25.4), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.divide(new BigDecimal(304.8), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.divide(new BigDecimal(914.4), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.divide(new BigDecimal(1000000)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "centimeters":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(10));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "meters":
						lengthResult = lengthAmount.divide(new BigDecimal(100));
						break;
					case "kilometers":
						lengthResult = lengthAmount.divide(new BigDecimal(100000));
						break;
					case "inches":
						lengthResult = lengthAmount.divide(new BigDecimal(2.54), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.divide(new BigDecimal(30.48), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.divide(new BigDecimal(91.44), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.divide(new BigDecimal(100000)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "meters":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1000));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(100));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "kilometers":
						lengthResult = lengthAmount.divide(new BigDecimal(1000));
						break;
					case "inches":
						lengthResult = lengthAmount.divide(new BigDecimal(0.0254), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.divide(new BigDecimal(0.348), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.divide(new BigDecimal(0.9144), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.divide(new BigDecimal(1000)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "kilometers":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1000000));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(100000));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1000));
						break;
					case "kilometers":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "inches":
						lengthResult = lengthAmount.divide(new BigDecimal(0.0000254), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.divide(new BigDecimal(0.000348), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.divide(new BigDecimal(0.0009144), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "inches":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(25.4));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(2.54));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0254));
						break;
					case "kilometers":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0000254));
						break;
					case "inches":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "feet":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0000254)).divide(new BigDecimal(0.000348), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0000254)).divide(new BigDecimal(0.0009144), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0000254)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "feet":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(304.8));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(30.48));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.3048));
						break;
					case "kilometers":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0003048));
						break;
					case "inches":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.000348)).divide(new BigDecimal(0.0000254), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "yards":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.000348)).divide(new BigDecimal(0.0009144), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.000348)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}	
				break;
			case "yards":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(914.4));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(91.44));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.9144));
						break;
					case "kilometers":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0009144));
						break;
					case "inches":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0009144)).divide(new BigDecimal(0.0000254), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0009144)).divide(new BigDecimal(0.000348), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
					case "miles":
						lengthResult = lengthAmount.multiply(new BigDecimal(0.0009144)).divide(new BigDecimal(1.609), 9, RoundingMode.HALF_UP);
						break;
				}	
				break;
			case "miles":
				switch (length_unit_to.trim()) {
					case "milimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1000000)).multiply(new BigDecimal(1.609));
						break;
					case "centimeters":
						lengthResult = lengthAmount.multiply(new BigDecimal(100000)).multiply(new BigDecimal(1.609));
						break;
					case "meters":
						lengthResult = lengthAmount.multiply(new BigDecimal(1000)).multiply(new BigDecimal(1.609));
						break;
					case "kilometers":
						lengthResult = lengthAmount.multiply(new BigDecimal(1.609));
						break;
					case "inches":
						lengthResult = lengthAmount.multiply(new BigDecimal(1.609)).divide(new BigDecimal(0.0000254), 9, RoundingMode.HALF_UP);
						break;
					case "feet":
						lengthResult = lengthAmount.multiply(new BigDecimal(1.609)).divide(new BigDecimal(0.000348), 9, RoundingMode.HALF_UP);
						break;
					case "yards":
						lengthResult = lengthAmount.multiply(new BigDecimal(1.609)).divide(new BigDecimal(0.0009144), 9, RoundingMode.HALF_UP);
						break;
					case "miles":
						lengthResult = lengthAmount.multiply(new BigDecimal(1));
						break;
				}
				break;
		}
		
		lengthResultStr = String.valueOf(lengthResult);
		lengthAmountStr = String.valueOf(lengthAmount);
		
        // Set data as an attribute in the request
		request.setAttribute("input", lengthAmountStr);
        request.setAttribute("result", lengthResultStr);
        request.setAttribute("unit_from", length_unit_from);
        request.setAttribute("unit_to", length_unit_to);
        
        // Dispatch the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsps/index.jsp");
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}