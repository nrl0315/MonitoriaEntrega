package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.*;

import java.util.UUID;

public final class MonitoriaDTOBuilder {
    private UUID id;
    private MonitorDTO monitor;
    private PlaceDTO place;
    private ScheduleDTO schedule;
    private TopicDTO topic;
    private ReviewDTO review;
    private OfferDTO offer;

    private MonitoriaDTOBuilder(){
        super();
    }

    public static final MonitoriaDTOBuilder getMonitoriaDTOBuilder(){
        return new MonitoriaDTOBuilder();
    }

    public final MonitoriaDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final MonitoriaDTOBuilder setMonitor(final MonitorDTO monitor) {
        this.monitor = monitor;
        return this;
    }

    public final MonitoriaDTOBuilder setPlace(final PlaceDTO place) {
        this.place = place;
        return this;
    }

    public final MonitoriaDTOBuilder setSchedule(final ScheduleDTO schedule) {
        this.schedule = schedule;
        return this;
    }

    public final MonitoriaDTOBuilder setTopic(final TopicDTO topic) {
        this.topic = topic;
        return this;
    }

    public final MonitoriaDTOBuilder setReview(final ReviewDTO review) {
        this.review = review;
        return this;
    }

    public final MonitoriaDTOBuilder setOffer(final OfferDTO offer) {
        this.offer = offer;
        return this;
    }

    public final MonitoriaDTO build(){
        return MonitoriaDTO.create(id,monitor,place,schedule,topic,review,offer);
    }
}
