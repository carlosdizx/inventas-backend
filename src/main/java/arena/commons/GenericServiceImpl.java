package arena.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

	@Override
	@Transactional
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	@Transactional
	public void delete(ID id) {
		getDao().deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T get(ID id)
	{
		return getDao().findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getDao();

}
