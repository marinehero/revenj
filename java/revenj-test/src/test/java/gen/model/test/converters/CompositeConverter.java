package gen.model.test.converters;



import java.io.*;
import java.util.*;
import java.util.stream.*;
import org.revenj.postgres.*;
import org.revenj.postgres.converters.*;

public class CompositeConverter implements ObjectConverter<gen.model.test.Composite> {

	@SuppressWarnings("unchecked")
	public CompositeConverter(List<ObjectConverter.ColumnInfo> allColumns) throws java.io.IOException {
		Optional<ObjectConverter.ColumnInfo> column;
		
			
		final java.util.List<ObjectConverter.ColumnInfo> columns =
				allColumns.stream().filter(it -> "test".equals(it.typeSchema) && "Composite_entity".equals(it.typeName))
				.collect(Collectors.toList());
		columnCount = columns.size();
			
		readers = new ObjectConverter.Reader[columnCount];
		for (int i = 0; i < readers.length; i++) {
			readers[i] = (instance, rdr, ctx) -> StringConverter.skip(rdr, ctx);
		}
			
		final java.util.List<ObjectConverter.ColumnInfo> columnsExtended =
				allColumns.stream().filter(it -> "test".equals(it.typeSchema) && "-ngs_Composite_type-".equals(it.typeName))
				.collect(Collectors.toList());
		columnCountExtended = columnsExtended.size();
			
		readersExtended = new ObjectConverter.Reader[columnCountExtended];
		for (int i = 0; i < readersExtended.length; i++) {
			readersExtended[i] = (instance, rdr, ctx) -> StringConverter.skip(rdr, ctx);
		}
			
		column = columns.stream().filter(it -> "id".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'id' column in test Composite_entity. Check if DB is in sync");
		__index___id = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "id".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'id' column in test Composite. Check if DB is in sync");
		__index__extended_id = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "enn".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'enn' column in test Composite_entity. Check if DB is in sync");
		__index___enn = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "enn".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'enn' column in test Composite. Check if DB is in sync");
		__index__extended_enn = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "en".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'en' column in test Composite_entity. Check if DB is in sync");
		__index___en = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "en".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'en' column in test Composite. Check if DB is in sync");
		__index__extended_en = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "simple".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'simple' column in test Composite_entity. Check if DB is in sync");
		__index___simple = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "simple".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'simple' column in test Composite. Check if DB is in sync");
		__index__extended_simple = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "change".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'change' column in test Composite_entity. Check if DB is in sync");
		__index___change = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "change".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'change' column in test Composite. Check if DB is in sync");
		__index__extended_change = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "tsl".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'tsl' column in test Composite_entity. Check if DB is in sync");
		__index___tsl = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "tsl".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'tsl' column in test Composite. Check if DB is in sync");
		__index__extended_tsl = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "entities".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'entities' column in test Composite_entity. Check if DB is in sync");
		__index___entities = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "entities".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'entities' column in test Composite. Check if DB is in sync");
		__index__extended_entities = (int)column.get().order - 1;
			
		column = columns.stream().filter(it -> "laziesURI".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'laziesURI' column in test Composite_entity. Check if DB is in sync");
		__index___laziesURI = (int)column.get().order - 1;
			
		column = columnsExtended.stream().filter(it -> "laziesURI".equals(it.columnName)).findAny();
		if (!column.isPresent()) throw new java.io.IOException("Unable to find 'laziesURI' column in test Composite. Check if DB is in sync");
		__index__extended_laziesURI = (int)column.get().order - 1;
	}

	public void configure(org.revenj.patterns.ServiceLocator locator) {
		
		__converter_simple = locator.resolve(gen.model.test.converters.SimpleConverter.class);
		__converter_entities = locator.resolve(gen.model.test.converters.EntityConverter.class);
		
			
		gen.model.test.Composite.__configureConverter(readers, __index___id, __index___enn, __index___en, __converter_simple, __index___simple, __index___change, __index___tsl, __converter_entities, __index___entities, __index___laziesURI);
			
		gen.model.test.Composite.__configureConverterExtended(readersExtended, __index__extended_id, __index__extended_enn, __index__extended_en, __converter_simple, __index__extended_simple, __index__extended_change, __index__extended_tsl, __converter_entities, __index__extended_entities, __index__extended_laziesURI);
	}

	@Override
	public String getDbName() {
		return "\"test\".\"Composite_entity\"";
	}

	@Override
	public gen.model.test.Composite from(PostgresReader reader) throws java.io.IOException {
		return from(reader, 0);
	}

	private gen.model.test.Composite from(PostgresReader reader, int outerContext, int context, ObjectConverter.Reader<gen.model.test.Composite>[] readers) throws java.io.IOException {
		reader.read(outerContext);
		gen.model.test.Composite instance = new gen.model.test.Composite(reader, context, readers);
		reader.read(outerContext);
		return instance;
	}

	@Override
	public PostgresTuple to(gen.model.test.Composite instance) {
		if (instance == null) return null;
		PostgresTuple[] items = new PostgresTuple[columnCount];
		
		items[__index___id] = org.revenj.postgres.converters.UuidConverter.toTuple(instance.getId());
		items[__index___enn] = org.revenj.postgres.converters.ArrayTuple.create(instance.getEnn(), gen.model.test.converters.EnConverter::toTuple);
		items[__index___en] = gen.model.test.converters.EnConverter.toTuple(instance.getEn());
		items[__index___simple] = __converter_simple.to(instance.getSimple());
		items[__index___change] = org.revenj.postgres.converters.DateConverter.toTuple(instance.getChange());
		items[__index___tsl] = org.revenj.postgres.converters.ArrayTuple.create(instance.getTsl(), org.revenj.postgres.converters.TimestampConverter::toTuple);
		items[__index___entities] = org.revenj.postgres.converters.ArrayTuple.create(instance.getEntities(), __converter_entities::to);
		if (instance.getLaziesURI() != null) items[__index___laziesURI] = org.revenj.postgres.converters.ArrayTuple.create(instance.getLaziesURI(), org.revenj.postgres.converters.ValueTuple::new);;
		return RecordTuple.from(items);
	}

	
	private final int columnCount;
	private final ObjectConverter.Reader<gen.model.test.Composite>[] readers;
	
	public gen.model.test.Composite from(PostgresReader reader, int context) throws java.io.IOException {
		int cur = reader.read();
		if (cur == ',' || cur == ')') return null;
		gen.model.test.Composite instance = from(reader, context, context == 0 ? 1 : context << 1, readers);
		reader.read();
		return instance;
	}

	public gen.model.test.Composite from(PostgresReader reader, int outerContext, int context) throws java.io.IOException {
		return from(reader, outerContext, context, readers);
	}
	
	public PostgresTuple toExtended(gen.model.test.Composite instance) {
		if (instance == null) return null;
		PostgresTuple[] items = new PostgresTuple[columnCountExtended];
		
		items[__index__extended_id] = org.revenj.postgres.converters.UuidConverter.toTuple(instance.getId());
		items[__index__extended_enn] = org.revenj.postgres.converters.ArrayTuple.create(instance.getEnn(), gen.model.test.converters.EnConverter::toTuple);
		items[__index__extended_en] = gen.model.test.converters.EnConverter.toTuple(instance.getEn());
		items[__index__extended_simple] = __converter_simple.toExtended(instance.getSimple());
		items[__index__extended_change] = org.revenj.postgres.converters.DateConverter.toTuple(instance.getChange());
		items[__index__extended_tsl] = org.revenj.postgres.converters.ArrayTuple.create(instance.getTsl(), org.revenj.postgres.converters.TimestampConverter::toTuple);
		items[__index__extended_entities] = org.revenj.postgres.converters.ArrayTuple.create(instance.getEntities(), __converter_entities::toExtended);
		if (instance.getLaziesURI() != null) items[__index__extended_laziesURI] = org.revenj.postgres.converters.ArrayTuple.create(instance.getLaziesURI(), org.revenj.postgres.converters.ValueTuple::new);;
		return RecordTuple.from(items);
	}
	private final int columnCountExtended;
	private final ObjectConverter.Reader<gen.model.test.Composite>[] readersExtended;
	
	public gen.model.test.Composite fromExtended(PostgresReader reader, int context) throws java.io.IOException {
		int cur = reader.read();
		if (cur == ',' || cur == ')') return null;
		gen.model.test.Composite instance = from(reader, context, context == 0 ? 1 : context << 1, readersExtended);
		reader.read();
		return instance;
	}

	public gen.model.test.Composite fromExtended(PostgresReader reader, int outerContext, int context) throws java.io.IOException {
		return from(reader, outerContext, context, readersExtended);
	}
	
	public static String buildURI(org.revenj.postgres.PostgresBuffer _sw, gen.model.test.Composite instance) throws java.io.IOException {
		_sw.initBuffer();
		String _tmp;
		org.revenj.postgres.converters.UuidConverter.serializeURI(_sw, instance.getId());
		return _sw.bufferToString();
	}
	private final int __index___id;
	private final int __index__extended_id;
	private final int __index___enn;
	private final int __index__extended_enn;
	private final int __index___en;
	private final int __index__extended_en;
	private gen.model.test.converters.SimpleConverter __converter_simple;
	private final int __index___simple;
	private final int __index__extended_simple;
	private final int __index___change;
	private final int __index__extended_change;
	private final int __index___tsl;
	private final int __index__extended_tsl;
	private gen.model.test.converters.EntityConverter __converter_entities;
	private final int __index___entities;
	private final int __index__extended_entities;
	private final int __index___laziesURI;
	private final int __index__extended_laziesURI;
}
