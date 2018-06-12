package com.game.util;

import java.util.Scanner;

public class ScannerUtilImpl implements ScannerUtil {
	private Scanner scanner;
	
	public ScannerUtilImpl() {
		scanner = new Scanner(System.in);
	}

	@Override
	public String nextInput() {
		return scanner.next();
	}

}
