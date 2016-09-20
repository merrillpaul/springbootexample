package hello.utils

import org.springframework.beans.MutablePropertyValues
import org.springframework.boot.bind.RelaxedDataBinder

/**
 * Created by upaulm2 on 9/20/16.
 */
final class DataBinderUtils {

	private DataBinderUtils() {}

	static void populateObjectFromProperties(def target, def properties) {
		new RelaxedDataBinder(target).bind(new MutablePropertyValues(properties))
	}
}
