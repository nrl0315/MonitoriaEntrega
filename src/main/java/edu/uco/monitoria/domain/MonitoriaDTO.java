package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.domain.builder.MonitorDTOBuilder.getMonitorDTOBuilder;
import static edu.uco.monitoria.domain.builder.OfferDTOBuilder.getOfferDTOBuilder;
import static edu.uco.monitoria.domain.builder.PlaceDTOBuilder.getPlaceDTOBuilder;
import static edu.uco.monitoria.domain.builder.ReviewDTOBuilder.getReviewDTOBuilder;
import static edu.uco.monitoria.domain.builder.ScheduleDTOBuilder.getScheduleDTOBuilder;
import static edu.uco.monitoria.domain.builder.TopicDTOBuilder.getTopicDTOBuilder;

public final class MonitoriaDTO {
    private UUID id;
    private MonitorDTO monitor;
    private PlaceDTO place;
    private ScheduleDTO schedule;
    private TopicDTO topic;
    private ReviewDTO review;
    private OfferDTO offer;

    public MonitoriaDTO (){
        setId(getDefaultUUID(id));
        setMonitor(getMonitorDTOBuilder().build());
        setPlace(getPlaceDTOBuilder().build());
        setSchedule(getScheduleDTOBuilder().build());
        setTopic(getTopicDTOBuilder().build());
        setReview(getReviewDTOBuilder().build());
        setOffer(getOfferDTOBuilder().build());
    }

    public MonitoriaDTO (final UUID id, final MonitorDTO monitor,final PlaceDTO place, final ScheduleDTO schedule, final TopicDTO topic,
                         final ReviewDTO review, final OfferDTO offer){
        setId(getDefaultUUID(id));
        setMonitor(monitor);
        setPlace(place);
        setSchedule(schedule);
        setTopic(topic);
        setReview(review);
        setOffer(offer);
    }

    public static final MonitoriaDTO create(final UUID id, final MonitorDTO monitor,final PlaceDTO place, final ScheduleDTO schedule, final TopicDTO topic,
                                            final ReviewDTO review, final OfferDTO offer){
        return new MonitoriaDTO(id,monitor,place,schedule,topic,review,offer);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
    }

    public MonitorDTO getMonitor() {
        return monitor;
    }

    public void setMonitor(MonitorDTO monitor) {
        this.monitor = monitor;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public ScheduleDTO getSchedule() {
        return schedule;
    }

    public void setSchedule(ScheduleDTO schedule) {
        this.schedule = schedule;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
    }

    public ReviewDTO getReview() {
        return review;
    }

    public void setReview(ReviewDTO review) {
        this.review = review;
    }

    public OfferDTO getOffer() {
        return offer;
    }

    public void setOffer(OfferDTO offer) {
        this.offer = offer;
    }
}
