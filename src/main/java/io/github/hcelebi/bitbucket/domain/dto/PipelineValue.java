package io.github.hcelebi.bitbucket.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.hcelebi.bitbucket.serializer.CustomDateTimeDeserializer;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineValue implements Serializable {
    @Serial
    private static final long serialVersionUID = 2050453806571365657L;
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    private DateTime created_on;
    private Integer duration_in_seconds;
    private PipelineResultTarget target;
    private PipelineValueState state;
}
