package com.grahamcrockford.oco.api;

import org.knowm.xchange.currency.CurrencyPair;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;

/**
 * A generic trade request.
 */
@AutoValue
@JsonDeserialize(builder = AdvancedOrderInfo.Builder.class)
public abstract class AdvancedOrderInfo {

  public static Builder builder() {
    return new AutoValue_AdvancedOrderInfo.Builder();
  }

  @AutoValue.Builder
  @JsonPOJOBuilder(withPrefix = "")
  public abstract static class Builder {
    @JsonCreator private static Builder create() { return AdvancedOrderInfo.builder(); }
    public abstract Builder exchange(String value);
    public abstract Builder counter(String value);
    public abstract Builder base(String value);
    public abstract AdvancedOrderInfo build();
  }

  @JsonIgnore
  public abstract Builder toBuilder();

  @JsonProperty
  public abstract String exchange();

  @JsonProperty
  public abstract String counter();

  @JsonProperty
  public abstract String base();

  @JsonIgnore
  public final String pairName() {
    return base() + "/" + counter();
  }

  @JsonIgnore
  public final CurrencyPair currencyPair() {
    return new CurrencyPair(base(), counter());
  }
}