package tw.com.microblog.basedao;

import java.util.List;

public class Dao<T> {

	private Class<T> clazz;

	public <E> E getValue(String sql, Object... obj) {

		return null;
	}

	public List<T> getList(String sql, Object... obj) {

		return null;
	}

	public T get(String sql, Object... obj) {

		return null;
	}

	public void save(String sql, Object... obj) {

	}

}
