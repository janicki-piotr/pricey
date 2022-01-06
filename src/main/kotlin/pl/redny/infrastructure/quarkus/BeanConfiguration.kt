package pl.redny.infrastructure.quarkus;

import pl.redny.infrastructure.LocalDateTimeService;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
class BeanConfiguration {

    @Produces
    fun dateTimeService(): LocalDateTimeService = LocalDateTimeService()

}
