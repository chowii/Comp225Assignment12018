import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

// These tests illustrate some basic properties of the methods you have been asked
// to implement. They are not exhaustive.
// For assessment there will also be cases where various combinations of
// the methods will be tested. You are strongly recommended to create some tests for
// yourself to ensure that your implementations satisfy all the specifications. 


public class AssignmentTests {
	@Test
	public void testSearchForwards() {
		
		String[] items = {"a","b","c","d","e","f"};
		ArrayList<DNode> list = createList(items);
		DNode head = list.get(0);
		DNode target = null;
		
		target = head.searchForwards(list.get(3), "a");
		assertNull(target);
		
		target = head.searchForwards(list.get(3), "e");
		assertSame(target, list.get(4));  // The two references should be the same
		assertSame(target.next, list.get(5));
		
		target = head.searchForwards(list.get(3), "f");
		assertSame(target, list.get(5));  
		assertSame(target.next, null);

		target = head.searchForwards(list.get(4), "e");
		assertSame(target, list.get(4));
		assertSame(target.next, list.get(5));

		target = head.searchForwards(list.get(3), "c");
		assertNotSame(target, list.get(4));
	}

	
	@Test
	public void testSearchBackwards() {

		String[] items = {"a","b","c","d","e","f"};
		ArrayList<DNode> list = createList(items);

		DNode head = list.get(0);
		DNode curr = list.get(3);
		DNode target = null;

		target = head.searchBackwards(curr, "f");
		assertNull(target);	
		
		target = head.searchBackwards(curr, "a");
		assertSame(target, list.get(0));
		assertSame(target.prev,null);

		target = head.searchBackwards(curr, "b");
		assertSame(target, list.get(1));
		assertSame(target.prev,list.get(0));
		
	}
	
	@Test
	public void testInsertAfter() {
		
		String[] items = {"a","b","c","d","e","f"};
		ArrayList<DNode> list = createList(items);

		String[] testArray = {"a","b","z","c","d","e","f"};
		
		DNode head = list.get(0);
		DNode curr = list.get(1);
		DNode newNode = new DNode("z");

		head.insertAfter(curr, newNode);
		
		DNode temp = head;
		for (int i = 0; i < testArray.length-1; i++){
			assertEquals(testArray[i], temp.contents);
			temp = temp.next;
		}
		assertEquals(testArray[testArray.length-1], temp.contents);
		
		for (int i = testArray.length-1; i >= 0; i--){
			assertEquals(testArray[i], temp.contents);
			temp = temp.prev;
		}
	}
	
	@Test
    public void testInsertAfterAtStart() {

        String[] items = {"a","b","c","d","e","f"};
        ArrayList<DNode> list = createList(items);

        String[] testArray = {"a","z","b","c","d","e","f"};

        DNode head = list.get(0);
        DNode curr = list.get(0);
        DNode newNode = new DNode("z");

        head.insertAfter(curr, newNode);

        DNode temp = head;
        for (int i = 0; i < testArray.length -1; i++) {
            assertEquals(testArray[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray[testArray.length-1], temp.contents);
            System.out.println();

        for (int i = testArray.length-1; i >= 0; i--){
            assertEquals(testArray[i], temp.contents);
            temp = temp.prev;
        }
    }

	@Test
    public void testInsertAfterAtEnd() {

        String[] items = {"a","b","c","d","e","f"};
        ArrayList<DNode> list = createList(items);

        String[] testArray = {"a","b","c","d","e","f","z"};

        DNode head = list.get(0);
        DNode curr = list.get(items.length - 1);
        DNode newNode = new DNode("z");

        head.insertAfter(curr, newNode);

        DNode temp = head;
        for (int i = 0; i < testArray.length -1; i++) {
            assertEquals(testArray[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray[testArray.length-1], temp.contents);

        for (int i = testArray.length-1; i >= 0; i--){
            assertEquals(testArray[i], temp.contents);
            temp = temp.prev;
        }
    }

    private void print(String temp) {
        System.out.print(temp + " ");
    }

    @Test
	public void testInsertBefore() {
		
		String[] items = {"a","b","c","d","e","f"};
		ArrayList<DNode> list = createList(items);

		String[] testArray = {"a","z","b","c","d","e","f"};
		
		DNode head = list.get(0);
		DNode curr = list.get(1);
		DNode newNode = new DNode("z");
		
		head.insertBefore(curr, newNode);
		
		DNode temp = head;
		for (int i = 0; i < testArray.length-1; i++){
			assertEquals(testArray[i], temp.contents);
			temp = temp.next;
		}
		assertEquals(testArray[testArray.length-1], temp.contents);
		
		for (int i = testArray.length-1; i >= 0; i--){
			assertEquals(testArray[i], temp.contents);
			temp = temp.prev;
		}
	}

    @Test
	public void testInsertBeforeAtStart() {

		String[] items = {"a","b","c","d","e","f"};
		ArrayList<DNode> list = createList(items);

		String[] testArray = {"z","a","b","c","d","e","f"};

		DNode head = list.get(0);
		DNode curr = list.get(0);
		DNode newNode = new DNode("z");

		head.insertBefore(curr, newNode);

		DNode temp = head;
		for (int i = 0; i < testArray.length-1; i++){
			assertEquals(testArray[i], temp.contents);
			temp = temp.next;
		}
		assertEquals(testArray[testArray.length-1], temp.contents);

		for (int i = testArray.length-1; i >= 0; i--){
			assertEquals(testArray[i], temp.contents);
			temp = temp.prev;
		}
	}

    @Test
    public void testInsertBeforeAtEnd() {

        String[] items = {"a", "b", "c", "d", "e", "f"};
        ArrayList<DNode> list = createList(items);

        String[] testArray = {"a", "b", "c", "d", "e", "z", "f"};

        DNode head = list.get(0);
        DNode curr = list.get(items.length - 1);
        DNode newNode = new DNode("z");

        head.insertBefore(curr, newNode);

        DNode temp = head;
        for (int i = 0; i < testArray.length - 1; i++) {
            assertEquals(testArray[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray[testArray.length - 1], temp.contents);

        for (int i = testArray.length - 1; i >= 0; i--) {
            assertEquals(testArray[i], temp.contents);
            temp = temp.prev;
        }
    }


	// The following tests concern the class DLSList

	@Test
	public void testAddNewNode() {
		String[] items = {"b","c","e"};
		ArrayList<DNode> list = createList(items);
		DNode head = list.get(0);

		DLSList testList= new DLSList();
		testList.head= head;
		testList.numNodes= items.length;
		testList.lastVisited= testList.head; // Initialise testList to satisfy the class invariant

		// now prepare and add a node
		DNode nodeToAdd= new DNode("d");
		testList.addNewNode(nodeToAdd);

		String testArray1[]= {"b", "c", "d", "e" };

		DNode temp= testList.head;
		for(int i=0; i< testArray1.length; i++){ // Checks the order of nodes starting from the first node
			assertEquals(testArray1[i], temp.contents);
			temp=temp.next;
		}
		assertEquals(testArray1.length, testList.numNodes);

		nodeToAdd= new DNode("f");
		testList.addNewNode(nodeToAdd);

		String testArray2[]= {"b", "c", "d", "e", "f" };
		temp = testList.head;
		for(int i=0; i< testArray2.length; i++){
			assertEquals(testArray2[i], temp.contents);
			temp=temp.next;
		}
		assertEquals(testArray2.length, testList.numNodes);

		nodeToAdd= new DNode("a");
		testList.addNewNode(nodeToAdd);

		String testArray3[]= {"a", "b", "c", "d", "e", "f" };
		temp = testList.head;
		for(int i=0; i< testArray3.length; i++){
			assertEquals(testArray3[i], temp.contents);
			temp=temp.next;
		}
		assertEquals(testArray3.length, testList.numNodes);
	}

    @Test
    public void testRemoveNode() {
        String[] items = {"a","b","c","d"};
        ArrayList<DNode> list = createList(items);
        DNode head = list.get(0);

        DLSList testList= new DLSList();
        testList.head= head;
        testList.numNodes= items.length;
        testList.lastVisited= testList.head; // Initialise testList to satisfy the class invariant

        // now remove a node
        testList.removeNode("a");

        String testArray1[]= {"b", "c", "d"};

        DNode temp= testList.head;
        for(int i=0; i< testArray1.length; i++){ // Checks the order of nodes starting from the first node
            assertEquals(testArray1[i], temp.contents);
            temp=temp.next;
        }
        assertEquals(testArray1.length, testList.numNodes);
    }

    @Test
    public void testRemoveNodeAtMiddle() {
        String[] items = {"a", "b", "c", "d"};
        ArrayList<DNode> list = createList(items);
        DNode head = list.get(0);

        DLSList testList = new DLSList();
        testList.head = head;
        testList.numNodes = items.length;
        testList.lastVisited = testList.head; // Initialise testList to satisfy the class invariant

        // now remove a node
        testList.removeNode("c");

        String testArray1[] = {"a", "b", "d"};

        DNode temp = testList.head;
        for (int i = 0; i < testArray1.length; i++) { // Checks the order of nodes starting from the first node
            assertEquals(testArray1[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray1.length, testList.numNodes);
    }

    @Test
    public void testRemoveNodeAtEnd() {
        String[] items = {"a", "b", "c", "d"};
        ArrayList<DNode> list = createList(items);
        DNode head = list.get(0);

        DLSList testList = new DLSList();
        testList.head = head;
        testList.numNodes = items.length;
        testList.lastVisited = testList.head; // Initialise testList to satisfy the class invariant

        // now remove a node
        testList.removeNode("d");

        String testArray1[] = {"a", "b", "c"};

        DNode temp = testList.head;
        for (int i = 0; i < testArray1.length; i++) { // Checks the order of nodes starting from the first node
            assertEquals(testArray1[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray1.length, testList.numNodes);
    }

    @Test
    public void testRemoveNodeNotInList() {
        String[] items = {"a", "b", "c", "d"};
        ArrayList<DNode> list = createList(items);
        DNode head = list.get(0);

        DLSList testList = new DLSList();
        testList.head = head;
        testList.numNodes = items.length;
        testList.lastVisited = testList.head; // Initialise testList to satisfy the class invariant

        // now remove a node
        testList.removeNode("e");

        String testArray1[] = {"a", "b", "c", "d"};

        DNode temp = testList.head;
        for (int i = 0; i < testArray1.length; i++) { // Checks the order of nodes starting from the first node
            assertEquals(testArray1[i], temp.contents);
            temp = temp.next;
        }
        assertEquals(testArray1.length, testList.numNodes);
    }

    @Test
    public void testVisit() {

		String[] items = {"a","b","c","d"};
		ArrayList<DNode> list = createList(items);
		DNode head = list.get(0);

		DLSList testList= new DLSList();
		testList.head= head;
		testList.numNodes= items.length;
		testList.lastVisited= testList.head; // Initialise testList to satisfy the class invariant

		DNode temp= testList.visit("b");
		DNode curr= list.get(1);


		assertSame(curr, temp);
		assertSame(curr, testList.lastVisited);
	}


	// The following tests concern the class SimpleBlockchain

	@Test
	public void testAddBlock() {
		SimpleBlockchain testBc= new SimpleBlockchain("hello");

		BlockchainNode newBc= new BlockchainNode ("number two", testBc.genesisNode.currHash, 1);

		testBc.addBlock("number two");

		assertEquals("number two", testBc.lastNode.contents);
		assertEquals(1, testBc.lastNode.blockNumber);
		assertEquals(newBc.currHash, testBc.lastNode.currHash);
		assertSame(testBc.genesisNode.next, testBc.lastNode);
	}


	@Test
	public void testValidate() {
		SimpleBlockchain testBc= new SimpleBlockchain("hello");

		testBc.addBlock("number two"); // assumes addBlock is correctly implemented

		assertTrue(testBc.validate());
	}


	@Test
	public void findTamperedNode() {
		SimpleBlockchain testBc= new SimpleBlockchain("hello");

		testBc.addBlock("number two"); // assumes addBlock is correctly implemented

		testBc.lastNode.contents= "something else"; // A simple attack: Change the block chain contents

		assertFalse(testBc.validate()); // No longer valid
		assertSame(testBc.lastNode, testBc.findTamperedNode()); // Last node has been altered

	}

	public ArrayList<DNode> createList(String[] items){
		ArrayList<DNode> list = new ArrayList<>();
		if (items.length > 0){
			list.add(new DNode(items[0],null,null));
			for (int i = 1; i < items.length; i++){
				DNode toAdd = new DNode(items[i],list.get(i-1),null);
				list.add(toAdd);
				list.get(i-1).next = toAdd;
			}
		}
		return list;
	}

}
