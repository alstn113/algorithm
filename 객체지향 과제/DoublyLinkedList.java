class Node {
  String nodeData;
  Node rightNode = null;
  Node leftNode = null;

  public Node(String nodeData) {
    this.nodeData = nodeData;
    this.rightNode = null;
    this.leftNode = null;
  }
}

public class DoublyLinkedList {
  Node listHead;
  Node listTail;
  int size;

  public DoublyLinkedList() {
    listHead = null;
    listTail = null;
    size = 0;
  }

  public void addFirst(String data) {
    Node newNode = new Node(data);

    if(listHead != null) {
      newNode.rightNode = listHead;
      listHead.leftNode = newNode;
    }

    listHead = newNode;
    if(listHead.rightNode == null) {
      listTail = listHead;
    }
    size++;
  }

  public void addLast(String data) {
    if(size == 0) {
      addFirst(data);
    } else {
      Node newNode = new Node(data);
      listTail.rightNode = newNode;
      newNode.leftNode = listTail;
      listTail = newNode;
      size++;
    }
  }

  public Node getNode(int index) {
    if (index < size/2) {
      Node node = listHead;
      for (int i=0; i<index; i++) {
        node = node.rightNode;
      }
      return node;
    } else {
      Node node = listTail;
      for (int i=size-1; i>index; i--) {
        node = node.leftNode;
      }
      return node;
    }
  }

  public void add(int index, String data) {
    if (index == 0) {
      addFirst(data);
    } else if(index == size -1) {
      addLast(data);
    } else {
      Node newNode = new Node(data);
      Node leftNode = getNode(index-1);
      Node rightNode = leftNode.rightNode;

      newNode.leftNode = leftNode;
      newNode.rightNode = rightNode;

      leftNode.rightNode = newNode;

      rightNode.leftNode = newNode;

      size++;
    }
  }

  public void removeFirst() {
    if(size == 0) {
      return;
    }

    Node removeNode = listHead;
    listHead = null;
    listHead = removeNode.rightNode;
    listHead.leftNode = null;
    size--;
  }

  public void removeLast() {
    if(size == 0) {
      return;
    }

    Node removeNode = listTail;
    listTail = null;
    listTail = removeNode.leftNode;
    listTail.rightNode = null;
    size--;
  }

  public void remove(int index) {
    if(size == 0) {
      return;
    }

    if(index == 0) {
      removeFirst();
    } else if(index == size-1) {
      removeFirst();
    } else {
      Node removeNode = getNode(index);
      Node leftNode = removeNode.leftNode;
      Node rightNode = removeNode.rightNode;

      leftNode.rightNode = rightNode;

      rightNode.leftNode = leftNode;

      size--;
    }
  }

  public void printList(){
    if(size == 0){
        System.out.println("출력할 내용이 존재하지 않습니다.");
    }else{
        Node current = listHead;
        while(current.rightNode != null){
          System.out.print(current.nodeData + " ");
          current = current.rightNode;
        }
        System.out.print(current.nodeData);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    list.addFirst("철수");
    list.addFirst("영희");
    list.addFirst("영수");
    list.addFirst("민수");
    list.printList();

    list.addLast("훈이");
    list.printList();
    
    list.add(1, "진구");
    list.printList();
    
    list.removeFirst();
    list.printList();

    list.removeLast();
    list.printList();

    list.remove(1);
    list.printList();
  }
}
