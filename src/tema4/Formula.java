//package tema4;

import java.util.ArrayList;

public class Formula {

	public static String getFormula(Info info) {

		String formula = "";
		ArrayList<String> variables[] = new ArrayList[info.number_nodes];
		String variabila = "";
		int current_number = 0;
		for (int i = 0; i < info.number_nodes; i++) {
			if(i==0){
			formula = formula + "(";
			}else{
				formula = formula + "^(";
			}
			variables[i] = new ArrayList<String>();

			for (int j = 0; j < info.number_colors; j++) {

				variabila = "x" + current_number;
				variables[i].add(variabila);
				current_number = current_number + 1;
				formula = formula + variabila + "V";

			}
			formula = formula.substring(0, formula.length() - 1) + ")";
			
			for (int j = 0; j < info.number_colors - 1; j++) {
				for (int k = j + 1; k < info.number_colors; k++) {
					variabila = "^(~" + variables[i].get(j);
					variabila = variabila + "V~" + variables[i].get(k) + ")";
					formula = formula + variabila;
				}
			}
		}

		for (Edges ed : info.edges) {
			for (int i = 0; i < info.number_colors; i++) {
				variabila = "^(~" + variables[ed.first].get(i);
				variabila = variabila + "V~" + variables[ed.second].get(i)+")";
				formula = formula + variabila;

			}
		}
		return formula;
	}

}
