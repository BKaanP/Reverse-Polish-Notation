package stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {



//	@Before
//	public void createStack() {
//		stack = new LinkedListStack<>();
//	}

	/**
	 * simple tests
	 */
	@Test
	public void testPush1() {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		assertEquals("a", stack.toString());
	}

	@Test
	public void testPush2() {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		stack.push("b");
		assertEquals("b, a", stack.toString());
	}

	@Test
	public void testPop() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		stack.push("b");
		stack.pop();
		assertEquals("a", stack.toString());
	}
	@Test
	public void testPop2() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.pop();
		assertEquals("b, a", stack.toString());
	}
	/**
	 * Axiom 1: isEmpty(new Stack()) = true
	 */
	@Test
	public void axiom1() {
		Stack<String> stack = new LinkedListStack<>();
		assertEquals(true, stack.isEmpty());
	}

	/**
	 * Axiom 2: isEmpty(push(q,x)) = false
	 */
	@Test
	public void axiom2() {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("A");
		assertEquals(false, stack.isEmpty());
	}

	/**
	 * Axiom 3: pop(new Stack()) = error
	 * 
	 * @throws Underflow
	 */
	@Test(expected = Underflow.class)
	public void axiom3() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.pop();
	}

	/**
	 * Axiom 4: getFront(new Stack()) = error
	 */
	@Test(expected = Underflow.class)
	public void axiom4() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.top();
	}

	/**
	 * Axiom 5: pop(push(s,x)) = x
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom5OnEmptyStack() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	@Test
	public void axiom5OnEmptyNonEmpty() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		stack.push("b");
		String before = stack.toString();
		stack.push("huhu");
		stack.pop();
		assertEquals(before, stack.toString());
	}

	/**
	 * Axiom 6: top(push(s,x)) = x
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom6OnEmptyStack() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}

	@Test
	public void axiom6() throws Underflow {
		Stack<String> stack = new LinkedListStack<>();
		stack.push("a");
		stack.push("b");

		String x = "huhu";
		stack.push(x);
		assertEquals(x, stack.top());
	}

}
