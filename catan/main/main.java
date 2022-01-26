package main;

import gameplay.GameManager;
import setup.SetupManager;

public class main {
	
	public static void main(String[] args) {
		SetupManager.getInstance().doAllSetup();
		GameManager.getInstance().doGameplay();
	}
}
