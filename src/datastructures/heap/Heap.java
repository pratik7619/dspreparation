package datastructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    Heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }
}
