import java.util.ArrayList;

public abstract class NodeHeuristic extends Node implements Comparable<NodeHeuristic> {
    protected int cost;

    public NodeHeuristic(NodeHeuristic parent, int depth, Board state) {
        super(parent, depth, state);

        if (parent == null) {
            cost = heuristic();
        } else {
            cost = parent.cost + heuristic();
        }
    }

    @Override
    public int compareTo(NodeHeuristic that) {
        return this.cost - that.cost;
    }

    protected abstract int heuristic();

    public abstract ArrayList<NodeHeuristic> getSuccessors();
}
