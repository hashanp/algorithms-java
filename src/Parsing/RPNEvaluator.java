package Parsing;

import java.util.Stack;

public class RPNEvaluator {
	public static enum ItemType {
		OPERATOR,
		OPERAND
	}
	
	public static class Item {
		ItemType itemType;
		int operand;
		char operator;
		
		public Item(int a) {
			itemType = ItemType.OPERAND;
			operand = a;
		}
		
		public Item(char a) {
			itemType = ItemType.OPERATOR;
			operator = a;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(evaluate("6 3 /"));
	}
	
	/*
	 * If this function is provided incorrect input, 
	 * it will not behave correctly
	 */
	public static int evaluate(String expr) {
		Stack<Item> items = new Stack<>();
	
		/*
		 *  Lexer
		 */
		String acc = ""; // Stores numbers while being processed
		
		for(String item: expr.split(" +")) { // One or more spaces
			if(item.matches("\\d+")) {
				items.push(new Item(Integer.parseInt(item)));
			} else {
				items.push(new Item(item.charAt(0)));
			}
		}
		
		/*
		 * Evaluator
		 */
		Stack<Item> items2 = new Stack<>();
		for(Item item: items) {
			if(item.itemType == ItemType.OPERAND) {
				items2.push(item);
			} else {
				int b = items2.pop().operand;
				int a = items2.pop().operand;
				if(item.operator == '+') {
					items2.push(new Item(a + b));
				} else if(item.operator == '-') {
					items2.push(new Item(a - b));
				} else if(item.operator == '*') {
					items2.push(new Item(a * b));
				} else if(item.operator == '/') {
					items2.push(new Item(a / b));
				}
			}
		}
		
		return items2.pop().operand;
	}
}
