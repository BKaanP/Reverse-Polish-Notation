package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class LinkedListStack<E> implements Stack<E> {

	E value = null;
	private int size =0; //defines length of array
	private E[] stk = (E[]) (new Object[size]); //array for use in methods

	@Override
	public boolean isEmpty() {
		// simple true/false based on size
		return size==0;
	}

	@Override
	public E top() throws Underflow {
		// act only if stack !isEmpty and return the top of array

		if(!isEmpty()){
			return stk[stk.length-1];
		}throw new Underflow();
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		size++;
		E[] tmp = (E[]) (new Object[size]);
		System.arraycopy(stk,0,tmp,0,stk.length);
		stk = tmp;
		stk[size-1] = element;
	}


	@Override
	public int size(){
		return size;
	}

	@Override
	public E pop() throws Underflow {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			E[] tmp = (E[]) (new Object[stk.length-1]);
			System.arraycopy(stk,0,tmp,0,stk.length-1);
				E value = stk[stk.length-1];
				stk = tmp.clone();
				size--;
				return value;
		}
		throw new Underflow();
	}

	@Override
	public String toString() {
		String result = Arrays.toString(stk);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(result.split(",")));
		Collections.reverse(list);
		return String.join(", ",list)
				.replaceAll("\\[","")
				.replaceAll("\\]","")
				.trim();
	}
}
