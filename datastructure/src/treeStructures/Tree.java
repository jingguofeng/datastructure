import java.lang.IllegalArgumentException;
import java.lang.Iterable;
import java.lang.Package;
import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {
    Position<E> root();
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    Iterable<Position<E>> children
}