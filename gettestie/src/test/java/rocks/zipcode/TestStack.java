package rocks.zipcode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.lang.model.type.IntersectionType;
import java.util.*;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

public class TestStack {

    private static final Logger LOGGER = Logger.getLogger(TestStack.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestStack1() {
        Stack<String> stack = new Stack<>();
        stack.push("Hello world");
        assertEquals(false, stack.isEmpty()); // false
    }

    @Test
    public void TestStack2() {
        Stack<String> stack = new Stack<>();
        stack.push("Hello world");

        String expected = "Hello world";
        String actual = stack.pop();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestStack3() {
        Stack<Integer> testStack = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            testStack.push(i);
        }
        boolean expected = true;
        boolean actual = testStack.contains(3);
        boolean expected2 = false;
        boolean actual2 = testStack.contains(6);
        int expected3 = 3;
        int actual3 = testStack.search(3);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    // Make a bigger test exercising more Stack methods.....
    @Test
    public void testSet() {
        Set<String> testSet = new HashSet<>();
        testSet.add("Captain America");
        testSet.add("Thor");
        testSet.add("Iron Man");
        testSet.add("AntMan");
        testSet.add("Wasp");
        testSet.add("Thor");
        int expected = 5;
        int actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSet2() {
        Set<String> testSet = new HashSet<>();
        testSet.add("Captain America");
        testSet.add("Iron Man");
        testSet.add("AntMan");
        testSet.add("Wasp");
        testSet.add("Thor");
        boolean expected = true;
        boolean actual = testSet.contains("Wasp");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSet3() {
        Set<String> testSet = new HashSet<>();
        testSet.add("Captain America");
        testSet.add("Iron Man");
        testSet.add("AntMan");
        testSet.add("Wasp");
        testSet.add("Thor");
        boolean expected = false;
        boolean actual = testSet.contains("Hulk");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSet4() {
        Set<String> testSet = new HashSet<>();
        testSet.add("Captain America");
        testSet.add("Iron Man");
        testSet.add("AntMan");
        testSet.add("Wasp");
        testSet.add("Thor");
        Integer expected = 4;
        testSet.remove("AntMan");
        Integer actual = testSet.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testList() {
        List<Person> testPeople = new ArrayList<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Ted", 1956);
        testPeople.add(testName);
        testPeople.add(testName2);
        testPeople.add(testName3);

        Integer expected = 3;
        Integer actual = testPeople.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testList2() {
        List<Person> testPeople = new ArrayList<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Ted", 1956);
        testPeople.add(testName);
        testPeople.add(testName2);
        testPeople.add(testName3);

        boolean expected = false;
        boolean actual = testPeople.isEmpty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testList3() {
        List<Person> testPeople = new ArrayList<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Ted", 1956);
        testPeople.add(testName);
        testPeople.add(testName2);
        testPeople.add(testName3);
        testPeople.clear();

        int expected = 0;
        int actual = testPeople.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMap() {
        Map<Person, Address> mapTest = new HashMap<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Henri", 1956);
        Address testAddress = new Address("123 Main Street", "Newark", "19708", "United States");
        Address testAddress2 = new Address("800 South Orange Street", "Odessa", "19801", "United States");
        Address testAddress3 = new Address("800 Rue de La Mer", "Paris", "E5G 7L9", "France");

        mapTest.put(testName, testAddress);
        mapTest.put(testName2, testAddress2);
        mapTest.put(testName3, testAddress3);

        int expected = 3;
        int actual = mapTest.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMap2() {
        Map<Person, Address> mapTest = new HashMap<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Henri", 1956);
        Address testAddress = new Address("123 Main Street", "Newark", "19708", "United States");
        Address testAddress2 = new Address("800 South Orange Street", "Odessa", "19801", "United States");
        Address testAddress3 = new Address("800 Rue de La Mer", "Paris", "E5G 7L9", "France");

        mapTest.put(testName, testAddress);
        mapTest.put(testName2, testAddress2);
        mapTest.put(testName3, testAddress3);
        mapTest.remove(testName2);

        Integer expected = 2;
        Integer actual = mapTest.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQueue() {
        Queue<Integer> queueTest = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++) {
            queueTest.add(i);
        }
        Integer expected = 1;
        Integer expected2 = 2;
        Integer actual = queueTest.remove();
        Integer actual2 = queueTest.peek();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testQueue2() {
        Queue<Integer> queueTest = new LinkedList<Integer>();
        for (int i = 1; i <= 5; i++) {
            queueTest.add(i);
        }
        queueTest.add(6);

        Integer expected = 6;
        Integer actual = queueTest.size();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testDeQue() {
        Deque<String> testDeque = new ArrayDeque<>();
        testDeque.add("First");
        testDeque.add("Second");
        testDeque.add("Third");
        testDeque.addFirst("Zero");
        testDeque.removeLast();

        String expected = "Second";
        String actual = testDeque.peekLast();
        Assert.assertEquals(expected, actual);

        Boolean expected2 = true;
        Boolean actual2 = testDeque.offer("Fourth");
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void testVector() {
        Vector<String> vectorTest = new Vector<>();
        vectorTest.addElement("Apple");
        vectorTest.addElement("Orange");
        vectorTest.addElement("Mango");
        vectorTest.addElement("Fig");
        LOGGER.log(Level.INFO, "value is: " + vectorTest);

        String expected = "Mango";
        String actual = vectorTest.get(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVector2() {
        Vector<String> vectorTest = new Vector<>();
        vectorTest.addElement("Apple");
        vectorTest.addElement("Orange");
        vectorTest.addElement("Mango");
        vectorTest.addElement("Fig");
        vectorTest.setElementAt("Pear", 3);

        String expected = "Pear";
        String actual = vectorTest.get(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVector3() {
        Vector<String> vectorTest = new Vector<>();

        Boolean expected = true;
        Boolean actual = vectorTest.isEmpty();
    }

    @Test
    public void testTreeMap() {
        TreeMap<Integer, Person> treeMapTest = new TreeMap<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Henri", 1956);
        treeMapTest.put(1, testName);
        treeMapTest.put(2,testName2);
        treeMapTest.put(3, testName3);
        LOGGER.log(Level.INFO, "value is: " + treeMapTest);
        Boolean expected = true;
        Boolean actual = treeMapTest.containsKey(2);
        Assert.assertEquals(expected, actual);

        Boolean expected2 = false;
        Boolean actual2 = treeMapTest.containsKey(4);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testTreeMap2() {
        TreeMap<Integer, Person> treeMapTest = new TreeMap<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Henri", 1956);
        treeMapTest.put(1, testName);
        treeMapTest.put(2, testName2);
        treeMapTest.put(3, testName3);

        Person expected = testName2;
        Person actual = treeMapTest.get(2);
        Assert.assertEquals(expected, actual);

        treeMapTest.remove(3);
        Integer expected2 = 2;
        Integer actual2 = treeMapTest.size();
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testTreeSet() {
        TreeSet<Integer> treeSetTest = new TreeSet<>();
        treeSetTest.add(10);
        treeSetTest.add(61);
        treeSetTest.add(87);
        treeSetTest.add(39);

        Integer expected = 39;
        Integer actual = treeSetTest.floor(60);
        Assert.assertEquals(expected, actual);

        Integer expected2 = 87;
        Integer actual2 = treeSetTest.ceiling(62);
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testTreeSet2() {
        TreeSet<Integer> treeSetTest = new TreeSet<>();
        treeSetTest.add(10);
        treeSetTest.add(61);
        treeSetTest.add(87);
        treeSetTest.add(39);
        treeSetTest.remove(61);

        Integer expected = 3;
        Integer actual = treeSetTest.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTreeSet3() {
        TreeSet<Integer> treeSetTest = new TreeSet<>();
        treeSetTest.add(10);
        treeSetTest.add(61);
        treeSetTest.add(87);
        treeSetTest.add(39);
        treeSetTest.add(10);

        Integer expected = 4;
        Integer actual = treeSetTest.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iteratorTest() {
        ArrayList<Integer> testIterator = new ArrayList<>();
        testIterator.add(10);
        testIterator.add(25);
        testIterator.add(37);
        testIterator.add(68);

        ListIterator<Integer> testIt = testIterator.listIterator();
        while (testIt.hasNext()) {
            Integer value = testIt.next();
            testIt.set(value + 10);
        }
        Integer expected = 35;
        Integer actual = testIterator.get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void priorityQueueTest() {
        PriorityQueue<Integer> pqTest = new PriorityQueue<>();
        pqTest.add(5);
        pqTest.add(3);
        pqTest.add(12);
        pqTest.add(25);
        pqTest.add(1);
        Integer expected = 1;
        Integer actual = pqTest.peek();
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void priorityQueueTest2() {
        PriorityQueue<Integer> pqTest = new PriorityQueue<>();
        pqTest.add(5);
        pqTest.add(3);
        pqTest.add(12);
        pqTest.add(25);
        pqTest.add(1);

        pqTest.poll();
        Integer expected = 3;
        Integer actual = pqTest.peek();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void comparableTest() {
        ArrayList<String> testList = new ArrayList<>();

        testList.add("E");
        testList.add("A");
        testList.add("C");
        testList.add("B");
        testList.add("D");

        Collections.sort(testList);
        String expected = "C";
        String actual = testList.get(2);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void comparatorTest() {
        List<Person> testPeople = new ArrayList<>();
        Person testName = new Person("Bob", 1975);
        Person testName2 = new Person("Carol", 1983);
        Person testName3 = new Person("Ted", 1956);
        testPeople.add(testName);
        testPeople.add(testName2);
        testPeople.add(testName3);

        class yobComp implements Comparator<Person> {
            public int compare(Person p1, Person p2) {
                if (p1.getYearOfBirth() == p2.getYearOfBirth())
                    return 0;
                else if (p1.getYearOfBirth() > p2.getYearOfBirth())
                    return 1;
                else return -1;
            }
        }
        Collections.sort(testPeople, new yobComp());
        Person expected = testName3;
        Person actual = testPeople.get(0);
        Assert.assertEquals(expected, actual);
        //LOGGER.log(Level.INFO, "value is: " + testPeople);
    }
}
