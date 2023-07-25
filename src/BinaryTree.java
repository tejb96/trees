import java.util.*;
public class BinaryTree {
	
	Node root;
	
	BinaryTree(){root=null;}
	
	public void ins(char data) {
		root=insert(data,root);
	}
	
	public Node insert(char data, Node root) {
		if(root==null) {
			return new Node(data);
		}
		if(data<root.data) {
			root.left=insert(data,root.left);
		}
		else {
			root.right=insert(data, root.right);
		}
		return root;
	}
	
	public void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public void preOrder(Node root) {
		if(root !=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void postOrder(Node root) {
		if(root !=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader=new Scanner(System.in);
		
		System.out.println("Enter the number of nodes:");
		int nodes = reader.nextInt();
		
		System.out.println("Enter the nodes:");
		
		char[] OGLetters=new char[nodes];
		for(int i=0;i<nodes;i++) {
			OGLetters[i]=reader.next().charAt(0);
		}
		reader.close();
		char[] shuffleLetters=OGLetters.clone();
		List<Character> shuffled=new ArrayList<>();
		for(char a: shuffleLetters) {
			shuffled.add(a);
		}
		Collections.shuffle(shuffled);
		shuffled.toArray();
		
		BinaryTree OGTree=new BinaryTree();
		BinaryTree shuffledTree=new BinaryTree();
		
		for(char letter:OGLetters) {
			OGTree.ins(letter);
		}
		
		for(char letter:shuffled) {
			shuffledTree.ins(letter);
		}
		
        System.out.println("\nOriginal Sequence of Nodes:");
        System.out.println("Inorder Traversal: ");
        OGTree.inOrder(OGTree.root);
        System.out.println("\nPreorder Traversal: ");
        OGTree.preOrder(OGTree.root);
        System.out.println("\nPostorder Traversal: ");
        OGTree.postOrder(OGTree.root);

        System.out.println("\n\nShuffled Sequence of Nodes:");
        System.out.println("Inorder Traversal: ");
        shuffledTree.inOrder(shuffledTree.root);
        System.out.println("\nPreorder Traversal: ");
        shuffledTree.preOrder(shuffledTree.root);
        System.out.println("\nPostorder Traversal: ");
        shuffledTree.postOrder(shuffledTree.root);
	}

}
