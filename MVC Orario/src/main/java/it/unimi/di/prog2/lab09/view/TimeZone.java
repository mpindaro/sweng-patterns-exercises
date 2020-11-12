package it.unimi.di.prog2.lab09.view;

import it.unimi.di.prog2.lab09.model.Time24;

public class TimeZone {
  private final String label;
  private final int offset;

  public TimeZone(String label, int minuteOffset) {
    this.label = label;
    this.offset = (minuteOffset + 24 * 60) % (24 * 60);
  }

  public String getLabel() {
    return label;
  }

  public Time24 convertFromGMT(Time24 time) {
    int minutes=time.getMin() + (time.getHour()*60) + offset;
    int hours = (minutes/60)%24 ;
    minutes=minutes%60;
    return new Time24(hours,minutes);
  }

  public Time24 convertToGMT(Time24 time) {
    int minutes;
    int hours;
    if (-offset > 0) {
       minutes = Math.abs(time.getMin() + (time.getHour() * 60) - offset);
       hours = (minutes / 60) % 24;
      minutes = minutes % 60;
    } else {
       minutes = Math.abs(time.getMin() + (time.getHour() * 60) - offset + 24*60);
       hours = (minutes / 60) % 24;
      minutes = minutes % 60;
    }
    return new Time24(hours,minutes);
  }
}
