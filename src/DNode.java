
import java.security.MessageDigest;

class DNode {
// Node for building a Doubly-linked list
	String contents;
	DNode next;
	DNode prev;	
	
	DNode (String k) {  // Constructor: builds a node which can be searahed forwards and backwards
		next= null; prev= null;
		contents= k;		
	}
	
	DNode (String k, DNode prev, DNode next){ // Constructor: builds a node with given references
		this.prev = prev;
		this.next = next;
		this.contents = k;
	}
	
	DNode searchForwards(DNode curr, String key) { //TODO
		// Post: DNode is an address of a doubly-linked list. 
		// returns the address of key if it occurs in the portion of the list
		// beginning at curr and ending at the last node. Returns null if key does not occur in that portion,
		// or if DNode is null.
		return null;		
	}
	
	DNode searchBackwards(DNode curr, String key) { //TODO
		// Post: DNode is an address of a doubly-linked list. 
		// returns the address of key if it occurs in the portion of the list
		// beginning at the head and ending at curr. Returns null if key does not occur in that portion,
		// or if DNode is null.
		return null;		
	}
	
	void insertAfter(DNode curr, DNode newNode) { //TODO
		// Pre: curr and newNode are addresses for DNodes
		// Post: newNode is inserted between curr and its next neighbour, i.e.
		// let N be newNode's next neighbour, then: curr.next points to newNode, newNode.next points to N
		// N.prev points to newNode and newNode.prev points to curr.
		// If curr has no next neighbour, then newNode is inserted as the last node after curr.
	}
	
	void insertBefore(DNode curr, DNode newNode) { //TODO
		// Pre: curr and newNode are addresses for DNodes
		// Post: newNode is inserted between curr and its previous neighbour, i.e.
		// let P be newNode's previous neighbour, then: P.next points to newNode, newNode.next points to curr
		// curr.prev points to newNode and newNode.next points to curr.
		// If curr has no previous neighbour, then newNode is inserted as the first node before curr.
	}
	
}

class DLSList {
	// Class invariant: The nodes in the list are sorted (ascending) according to the contents
	// AND numNodes == the number of nodes in the list
	// AND (lastVisited points to the node which was last valid access after method visit is called
	//     OR is set to head (in case removeNode demands it) or it is initialised)
	DNode head;  // The first node in the list
	DNode lastVisited; // The address of the node last visited
	int numNodes; // The number of nodes in the list
	
	DLSList (){
		head= null;
		lastVisited= null;
		numNodes= 0;
	}
	
	void addNewNode(DNode newNode) { //TODO
		// Post: newNode is inserted into the current list in correct sorted order
		// numNodes is adjusted to be equal to the number of nodes in the list
	}
	
	void removeNode(String key) { //TODO
		// Post: All occurrences of nodes with contents field equal to key are removed.
		// If lastVisited points to one of the removed nodes, then lastVisited is set to head
		// numNodes is adjusted to be equal to the number of nodes in the list
	}
	
	DNode visit(String key) { //TODO
		// Post: Returns the address of the first node (in ascending order) whose contents equal key, and null if there is no such node;
		// lastVisited is set to the address returned if it is not null, otherwise lastVisited remains unchanged
		return null;
	}
	
	
}

class BlockchainNode { // The basic BlockchainNode...
	String currHash;  // To store the hash
	String contents;  // To store the data
	int blockNumber;  // The number of the node in the block after the Genesis Node
	BlockchainNode next; // The next BlockchainNode
	BlockchainNode prev; // The previous BlockchainNode
	
	BlockchainNode (String s) {
		// Creates a Genesis node
		currHash= StringUtil.applySha256(Integer.toString(0)+"AllZeros:This is the Genesis String!"+s);
		contents= s;
		blockNumber= 0;
		next= null;
		prev= null;
	}	
	
	BlockchainNode (String s, String pH, int bN) {
	// Creates a new blocknumbered bN with contents s	
		currHash= StringUtil.applySha256(Integer.toString(bN)+pH+s);
		contents= s;
		blockNumber= bN;
		next= null;	
		prev= null;
	}
}

class SimpleBlockchain {
	// Class invariant: all nodes in the Blockchain satisfy "Blockchain Validity"
	// i.e.  Blockchain Validity holds of all nodes (except the Genesis node):
	// StringUtil.applySha256(this.blockNumber+ prev.currHash+this.contents == this.currHash)
	// AND the Genesis node has been correctly initialised
	BlockchainNode genesisNode; // Created by calling BlockchainNode (String s)
	BlockchainNode lastNode;   // The last node in the Blockchain

		SimpleBlockchain(String s){
			genesisNode= new BlockchainNode(s);
			lastNode= genesisNode;
		}
		
	
	void addBlock(String s) { //TODO
		// Post: Creates a new valid block with contents s, and adds it
		// to the current SimpleBlockchain so that the result satisfies the blockchain condition.
	}
	
	boolean validate () { //TODO
		// Post: Returns true if the SimpleBlockchain is valid, i.e. satisfies the blockChain condition
		// null SimplBlockchains are valid
		return true;
	}	
	
	SimpleBlockchain findTamperedNode() { //TODO
		// Post: If validate returns false, returns the address of the first node which fails to validate
		// If validate returns true, then returns null
		return null;
	}
	
} 


/// This is what we will use for the hash function in making a blockchain
/// Do not change or remove this code
class StringUtil {
	//Applies Sha256 to a string and returns the result. 
	public static String applySha256(String input){		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}	
}
