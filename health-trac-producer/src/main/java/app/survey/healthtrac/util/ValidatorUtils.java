package app.survey.healthtrac.util;

import app.survey.healthtrac.exception.ApplicationException;

public class ValidatorUtils {

	public static SearchByEnum validateSearchBy(String searchBy) {
		try {
			return SearchByEnum.valueOf(searchBy);
		} catch(IllegalArgumentException | NullPointerException iae) {
			throw new ApplicationException(MessageConstants.INVALID_SEARCHBY_RECEIVED);
		}
	}

}
