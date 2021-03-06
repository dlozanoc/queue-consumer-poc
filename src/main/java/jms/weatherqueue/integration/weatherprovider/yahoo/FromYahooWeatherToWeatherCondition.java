package jms.weatherqueue.integration.weatherprovider.yahoo;

import java.util.Optional;

import jms.weatherqueue.domain.WeatherCondition;
import jms.weatherqueue.integration.weatherprovider.ToWeatherConditionConverter;

public class FromYahooWeatherToWeatherCondition implements ToWeatherConditionConverter<WeatherInformationResource> {

	@Override
	public Optional<WeatherCondition> apply(WeatherInformationResource from) {
		return Optional.of(
				new WeatherCondition(
					from.getQuery().getResults().getChannel().getItem().getCondition().getCode(),
					from.getQuery().getResults().getChannel().getItem().getCondition().getDate(), 
					Integer.valueOf(from.getQuery().getResults().getChannel().getItem().getCondition().getTemperature()),
					from.getQuery().getResults().getChannel().getItem().getCondition().getDescription(),
					from.getQuery().getCreatedAt()));
	}
	
	
}
