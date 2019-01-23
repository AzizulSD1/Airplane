// Author Name: Azizul Hakim   
// Date: 1/13/2019
// Program Name: Hakim_Airplane
// Purpose: Simulation using "call" button, call attendant

import java.util.Scanner;

public class Hakim_Airplane 
{
	public static void main(String[] args)
	{
		// instantiate a new instance of Airplane
		Airplane plane = new Airplane();
		Scanner input = new Scanner(System.in);
				
	
		while(true)
		{
			boolean[] values = plane.getLightStatus();
			
			for(boolean seat : values)
				System.out.println(seat ? "Off " : "On ");

			System.out.println("Enter a command: (type 'h' for help)");
			String choice = input.nextLine();
			
			// options menu
			switch(choice.charAt(0))
			{
				// type h for help menu
				case 'h':
					System.out.println("t: turn on/off all lights");
					System.out.println("c(seat): turn off a single seat's light");
					System.out.println();
					break;
				
				// type c to toggle a single seat's light
				case 'c':
					int seat = Integer.parseInt(choice.substring(1));
					plane.callAttendant(seat);
					break;
					
				// type t to toggle all the lights on and off
				case 't':
					plane.toggleLights();
					break;
					
			}
		}
	}
}

class Airplane
{
	// create array for lights
	private boolean lights[] = new boolean[5];
	
	public boolean[] getLightStatus()
	{
		return lights;
	}
	
	public void callAttendant(int seatNumber)
	{
		lights[seatNumber] = true;
	}
	
	public void toggleLights()
	{
		// loop through array of lights and turn them all on/off
		for(int i = 0; i < 5; i++)
		{
			// if they're on, turn them all off
			if(lights[i] == true)
				lights[i] = false;

			// if they're off, turn them all on
			else if(lights[i] == false)
				lights[i] = true;
		}
		
		System.out.println();
		
	}
}
