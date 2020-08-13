package ch.kferati.roommanager.data;

public interface Repository {
	<T> boolean add(T element);
	<T> boolean delete(T element);
	<T> boolean update(T element);
	<T> boolean get(T element);
}