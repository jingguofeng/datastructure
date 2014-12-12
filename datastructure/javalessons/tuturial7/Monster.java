package tuturial7;

public class Monster {

	public final String TOMBSTONE = "Here Lies a Dead monster";
	//field
	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private int xPosition = 0;
	private int yPosition = 0;
	private boolean alive = true;
	
	public String name = "Big Monster";
	
	public int getAttack(){
		return attack;
	}
	
	public int getMovement(){
		return movement;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setHealth(int decreaseHealth){
		health = health - decreaseHealth;
		if(health < 0){
			alive = false;
		}
	}
	
	//overloaded method attribute should be different!! Not just the return type.
	public void setHealth(double decreaseHealth){
		
		int intDecreaseHealth = (int) decreaseHealth;
		health = health - intDecreaseHealth;
		if(health < 0 ){
			alive = false;
		}
	}
	
	//constructor
	public Monster(int newHealth, int newAttack, int newMovement){
		health = newHealth;
		attack = newAttack;
		movement = newMovement;
	}
	
	//Default Constructor if you don't define any constructors
	public Monster(){
		
	}
	
	public static void main(String[] args){
		Monster Frank = new Monster();
		
		System.out.println(Frank.attack);
	}
	
}
