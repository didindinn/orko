package com.grahamcrockford.oco.orders;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogColumn {

  static Builder builder() {
    return new AutoValue_LogColumn.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    public abstract Builder name(String name);
    public abstract Builder width(int width);
    public abstract Builder rightAligned(boolean rightAligned);
    public abstract LogColumn build();
  }

  public abstract String name();
  public abstract int width();
  public abstract boolean rightAligned();
}
