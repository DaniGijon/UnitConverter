package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet("/Weight")
public class WeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String weight_input_str = request.getParameter("weight_input");
		String weight_unit_from = request.getParameter("weight_unit_from");
		String weight_unit_to = request.getParameter("weight_unit_to");
		
		BigDecimal weightAmount = new BigDecimal(weight_input_str);
		BigDecimal weightResult = new BigDecimal(0);
		String weightResultStr="";
		
		switch (weight_unit_from.trim()) {
			case "milligram":
				switch (weight_unit_to.trim()) {
					case "milligram":
						weightResult = weightAmount.multiply(new BigDecimal(1));
						break;
					case "gram":
						weightResult = weightAmount.divide(new BigDecimal(1000));
						break;
					case "kilogram":
						weightResult = weightAmount.divide(new BigDecimal(1000000));
						break;
					case "ounce":
						weightResult = weightAmount.divide(new BigDecimal(1000)).divide(new BigDecimal(28.35), 9, RoundingMode.HALF_UP);
						break;
					case "pound":
						weightResult = weightAmount.divide(new BigDecimal(1000)).divide(new BigDecimal(453.6), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "gram":
				switch (weight_unit_to.trim()) {
				case "milligram":
					weightResult = weightAmount.multiply(new BigDecimal(1000));
					break;
				case "gram":
					weightResult = weightAmount.multiply(new BigDecimal(1));
					break;
				case "kilogram":
					weightResult = weightAmount.divide(new BigDecimal(1000));
					break;
				case "ounce":
					weightResult = weightAmount.divide(new BigDecimal(28.35), 9, RoundingMode.HALF_UP);
					break;
				case "pound":
					weightResult = weightAmount.divide(new BigDecimal(453.6), 9, RoundingMode.HALF_UP);
					break;
				}
				break;
			case "kilogram":
				switch (weight_unit_to.trim()) {
					case "milligram":
						weightResult = weightAmount.multiply(new BigDecimal(1000000));
						break;
					case "gram":
						weightResult = weightAmount.multiply(new BigDecimal(1000));
						break;
					case "kilogram":
						weightResult = weightAmount.multiply(new BigDecimal(1));
						break;
					case "ounce":
						weightResult = weightAmount.multiply(new BigDecimal(1000)).divide(new BigDecimal(28.35), 9, RoundingMode.HALF_UP);
						break;
					case "pound":
						weightResult = weightAmount.multiply(new BigDecimal(1000)).divide(new BigDecimal(453.6), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "ounce":
				switch (weight_unit_to.trim()) {
					case "milligram":
						weightResult = weightAmount.multiply(new BigDecimal(28.35)).multiply(new BigDecimal(1000));
						break;
					case "gram":
						weightResult = weightAmount.multiply(new BigDecimal(28.35));
						break;
					case "kilogram":
						weightResult = weightAmount.multiply(new BigDecimal(28.35)).divide(new BigDecimal(1000));
						break;
					case "ounce":
						weightResult = weightAmount.multiply(new BigDecimal(1));
						break;
					case "pound":
						weightResult = weightAmount.multiply(new BigDecimal(28.35)).divide(new BigDecimal(453.6), 9, RoundingMode.HALF_UP);
						break;
				}
				break;
			case "pound":
				switch (weight_unit_to.trim()) {
				case "milligram":
					weightResult = weightAmount.multiply(new BigDecimal(453.6)).multiply(new BigDecimal(1000));
					break;
				case "gram":
					weightResult = weightAmount.multiply(new BigDecimal(453.6));
					
					break;
				case "kilogram":
					weightResult = weightAmount.multiply(new BigDecimal(453.6)).divide(new BigDecimal(1000));
					break;
				case "ounce":
					weightResult = weightAmount.multiply(new BigDecimal(453.6)).divide(new BigDecimal(28.35), 9, RoundingMode.HALF_UP);
					break;
				case "pound":
					weightResult = weightAmount.multiply(new BigDecimal(1));
					break;
			}
			break;
		}
		
		weightResultStr = String.valueOf(weightResult);
		
        // Set data as an attribute in the request
		request.setAttribute("input", weight_input_str);
        request.setAttribute("result", weightResultStr);
        request.setAttribute("unit_from", weight_unit_from);
        request.setAttribute("unit_to", weight_unit_to);
        
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
