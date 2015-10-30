package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPersona is a Querydsl query type for Persona
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPersona extends EntityPathBase<Persona> {

    private static final long serialVersionUID = -1296017862;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QPersona persona = new QPersona("persona");

    public final StringPath apellido1 = createString("apellido1");

    public final StringPath apellido2 = createString("apellido2");

    public final NumberPath<Integer> codPostal = createNumber("codPostal", Integer.class);

    public final StringPath domicilio = createString("domicilio");

    public final StringPath email = createString("email");

    public final StringPath estadoCarta = createString("estadoCarta");

    public final StringPath estadoEtiqueta = createString("estadoEtiqueta");

    public final StringPath expedProhibicion = createString("expedProhibicion");

    public final DateTimePath<java.util.Date> fechaNacimiento = createDateTime("fechaNacimiento", java.util.Date.class);

    public final NumberPath<Long> idMunicipio = createNumber("idMunicipio", Long.class);

    public final NumberPath<Long> idPais = createNumber("idPais", Long.class);

    public final NumberPath<Long> idPersona = createNumber("idPersona", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastUpdate = createDateTime("lastUpdate", java.sql.Timestamp.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath nombre = createString("nombre");

    public final StringPath numDocIdent = createString("numDocIdent");

    public final StringPath observaciones = createString("observaciones");

    public final NumberPath<Integer> pendienteCompletar = createNumber("pendienteCompletar", Integer.class);

    public final ListPath<Prohibicion, QProhibicion> prohibiciones = this.<Prohibicion, QProhibicion>createList("prohibiciones", Prohibicion.class, QProhibicion.class, PathInits.DIRECT);

    protected QProvincia provincia;

    public final StringPath sexo = createString("sexo");

    public final StringPath telefono = createString("telefono");

    protected QTipoDocIdentidad tipoDocIdent;

    public QPersona(String variable) {
        this(Persona.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QPersona(Path<? extends Persona> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersona(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPersona(PathMetadata<?> metadata, PathInits inits) {
        this(Persona.class, metadata, inits);
    }

    public QPersona(Class<? extends Persona> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.provincia = inits.isInitialized("provincia") ? new QProvincia(forProperty("provincia"), inits.get("provincia")) : null;
        this.tipoDocIdent = inits.isInitialized("tipoDocIdent") ? new QTipoDocIdentidad(forProperty("tipoDocIdent")) : null;
    }

    public QProvincia provincia() {
        if (provincia == null){
            provincia = new QProvincia(forProperty("provincia"));
        }
        return provincia;
    }

    public QTipoDocIdentidad tipoDocIdent() {
        if (tipoDocIdent == null){
            tipoDocIdent = new QTipoDocIdentidad(forProperty("tipoDocIdent"));
        }
        return tipoDocIdent;
    }

}

