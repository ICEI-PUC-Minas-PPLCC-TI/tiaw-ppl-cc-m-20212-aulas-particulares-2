package app;

import dao.ProfessorDao;
import model.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class teste {

	public static boolean contains(String[] l, String s) {
		boolean resp = false;
		for(int i = 0; i < l.length; i++) {
			if(s.equals(l[i]) ==  true) {
				resp = true;
				System.out.println("" + l[i] + " eh igual a " + s);
				i = l.length;
			}
			
		}
		
		return resp;
	}
	
	public static void main(String[] args) {
		Professor p = new Professor("Pedro Pampolini", "pedro@email.com", "00000000000", "admin",
				"m", "30/11/2000","31340610","Bh","MG","p",123);
		ProfessorDao professorDao = new ProfessorDao();
		professorDao.insert(p);
		
		List<Professor> professores = professorDao.get();
		for(int i = 0; i < professores.size(); i++) {
			System.out.println("professor " + i + ": " + professores.get(i).toString());
		}
		
		
		String id = new Scanner(System.in).nextLine();
		professorDao.delete(id);
		System.out.println("Fim : " + professores.size());
	}
}
