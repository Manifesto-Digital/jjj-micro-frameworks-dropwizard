package uk.co.manifesto.javasessions.dropwizard.api;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Wine {
	private static final AtomicInteger COUNTER = new AtomicInteger();
	
	@JsonIgnore
	private final int id;
	private String name;
	private String origin;

	public Wine(String name, String origin) {
		this.id = COUNTER.getAndIncrement();
		this.name = name;
		this.origin = origin;
	}

	public Wine() {
		this.id = COUNTER.getAndIncrement();
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wine)) {
            return false;
        }

        final Wine that = (Wine) o;

        return 
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.origin, that.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, origin);
    }
}
