package gen.model.Seq;



public class Next   implements java.lang.Cloneable, java.io.Serializable, org.revenj.patterns.AggregateRoot {
	
	
	
	public Next() {
			
		this.ID = 0;
		this.ID = --__SequenceCounterID__;
		this.URI = java.lang.Integer.toString(this.ID);
	}

	
	private String URI;

	
	@com.fasterxml.jackson.annotation.JsonProperty("URI")
	public String getURI()  {
		
		return this.URI;
	}

	
	@Override
	public int hashCode() {
		return URI.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null || obj instanceof Next == false)
			return false;
		final Next other = (Next) obj;
		return URI.equals(other.URI);
	}

	public boolean deepEquals(final Next other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (!URI.equals(other.URI))
			return false;
		
		if(!(this.ID == other.ID))
			return false;
		return true;
	}

	private Next(Next other) {
		this.URI = other.URI;
		this.__locator = other.__locator;
		this.ID = other.ID;
		this.__originalValue = other.__originalValue;
	}

	@Override
	public Object clone() {
		return new Next(this);
	}

	@Override
	public String toString() {
		return "Next(" + URI + ')';
	}
	
	private transient java.util.Optional<org.revenj.patterns.ServiceLocator> __locator = java.util.Optional.empty();
	private static final long serialVersionUID = 2171179118054500800L;
	
	@com.fasterxml.jackson.annotation.JsonCreator private Next(
			@com.fasterxml.jackson.annotation.JsonProperty("URI") final String URI ,
			@com.fasterxml.jackson.annotation.JacksonInject("__locator") final org.revenj.patterns.ServiceLocator __locator,
			@com.fasterxml.jackson.annotation.JsonProperty("ID") final int ID) {
		this.URI = URI != null ? URI : new java.util.UUID(0L, 0L).toString();
		this.__locator = java.util.Optional.ofNullable(__locator);
		this.ID = ID;
	}

	
	private int ID;

	
	@com.fasterxml.jackson.annotation.JsonProperty("ID")
	public int getID()  {
		
		return ID;
	}

	
	private Next setID(final int value) {
		
		this.ID = value;
		
		return this;
	}

	
	static {
		gen.model.Seq.repositories.NextRepository.__setupSequenceID((items, connection) -> {
			try (java.sql.PreparedStatement st = connection.prepareStatement("/*NO LOAD BALANCE*/SELECT nextval('\"Seq\".\"Next_ID_seq\"'::regclass)::int FROM generate_series(1, ?)")) {
				st.setInt(1, items.size());
				try (java.sql.ResultSet rs = st.executeQuery()) {
					java.util.Iterator<Next> iterator = items.iterator();
					while (rs.next()) {
						iterator.next().setID(rs.getInt(1));
					}
				}
			} catch (java.sql.SQLException e) {
				throw new RuntimeException(e);
			}
		});
	}
	
	private static int __SequenceCounterID__;
	

public static class BetweenIds   implements java.io.Serializable, org.revenj.patterns.Specification<Next> {
	
	
	
	public BetweenIds(
			 final Integer min,
			 final int max) {
			
		setMin(min);
		setMax(max);
	}

	
	
	public BetweenIds() {
			
		this.max = 0;
	}

	private static final long serialVersionUID = 3848366226739958478L;
	
	private Integer min;

	
	@com.fasterxml.jackson.annotation.JsonProperty("min")
	public Integer getMin()  {
		
		return min;
	}

	
	public BetweenIds setMin(final Integer value) {
		
		this.min = value;
		
		return this;
	}

	
	private int max;

	
	@com.fasterxml.jackson.annotation.JsonProperty("max")
	public int getMax()  {
		
		return max;
	}

	
	public BetweenIds setMax(final int value) {
		
		this.max = value;
		
		return this;
	}

	
		public boolean test(gen.model.Seq.Next it) {
			return ( this.getMin() == null ||  ( (it.getID() >= this.getMin()) &&  (it.getID() <= this.getMax())));
		}
}

	private transient Next __originalValue;
	
	static {
		gen.model.Seq.repositories.NextRepository.__setupPersist(
			(aggregates, arg) -> {
				try {
					for (gen.model.Seq.Next agg : aggregates) {
						 
						agg.URI = gen.model.Seq.converters.NextConverter.buildURI(arg, agg);
					}
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			},
			(oldAggregates, newAggregates) -> {
				for (int i = 0; i < newAggregates.size(); i++) {
					gen.model.Seq.Next oldAgg = oldAggregates.get(i);
					gen.model.Seq.Next newAgg = newAggregates.get(i);
					 
				}
			},
			aggregates -> { 
				for (gen.model.Seq.Next agg : aggregates) { 
				}
			},
			agg -> { 
				
		Next _res = agg.__originalValue;
		agg.__originalValue = (Next)agg.clone();
		if (_res != null) {
			return _res;
		}
				return null;
			}
		);
	}
	
	public Next(org.revenj.postgres.PostgresReader reader, int context, org.revenj.postgres.ObjectConverter.Reader<Next>[] readers) throws java.io.IOException {
		for (org.revenj.postgres.ObjectConverter.Reader<Next> rdr : readers) {
			rdr.read(this, reader, context);
		}
		URI = gen.model.Seq.converters.NextConverter.buildURI(reader, this);
		this.__locator = java.util.Optional.ofNullable(reader.locator);
		this.__originalValue = (Next)this.clone();
	}

	public static void __configureConverter(org.revenj.postgres.ObjectConverter.Reader<Next>[] readers, int __index___ID) {
		
		readers[__index___ID] = (item, reader, context) -> { item.ID = org.revenj.postgres.converters.IntConverter.parse(reader); };
	}
	
	public static void __configureConverterExtended(org.revenj.postgres.ObjectConverter.Reader<Next>[] readers, int __index__extended_ID) {
		
		readers[__index__extended_ID] = (item, reader, context) -> { item.ID = org.revenj.postgres.converters.IntConverter.parse(reader); };
	}
}
