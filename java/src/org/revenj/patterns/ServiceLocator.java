package org.revenj.patterns;

import java.lang.reflect.Type;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface ServiceLocator {
	Optional<Object> tryResolve(Type type);

	default <T> T resolve(Class<T> manifest) {
		Optional<Object> found = tryResolve(manifest);
		if (!found.isPresent()) {
			throw new NoSuchElementException(manifest.getName());
		}
		return (T) found.get();
	}
}
