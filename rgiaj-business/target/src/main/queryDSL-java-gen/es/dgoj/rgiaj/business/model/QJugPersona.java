package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugPersona is a Querydsl query type for JugPersona
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugPersona extends EntityPathBase<JugPersona> {

    private static final long serialVersionUID = 1141591618;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugPersona jugPersona = new QJugPersona("jugPersona");

    public final StringPath apellido1 = createString("apellido1");

    public final StringPath apellido2 = createString("apellido2");

    public final NumberPath<Integer> codPostal = createNumber("codPostal", Integer.class);

    public final StringPath domicilio = createString("domicilio");

    public final StringPath email = createString("email");

    public final StringPath estadoCarta = createString("estadoCarta");

    public final StringPath estadoEtiqueta = createString("estadoEtiqueta");

    public final StringPath expedProhibicion = createString("expedProhibicion");

    public final DateTimePath<java.util.Date> fechaNacimiento = createDateTime("fechaNacimiento", java.util.Date.class);

    public final NumberPath<Long> idPersona = createNumber("idPersona", Long.class);

    public final ListPath<JugProhibicion, QJugProhibicion> jugProhibicionList = this.<JugProhibicion, QJugProhibicion>createList("jugProhibicionList", JugProhibicion.class, QJugProhibicion.class, PathInits.DIRECT);

    protected QJugProvincia jugProvincia;

    public final DateTimePath<java.util.Date> lastUpdate = createDateTime("lastUpdate", java.util.Date.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath nombre = createString("nombre");

    public final StringPath numDocIdent = createString("numDocIdent");

    public final StringPath observaciones = createString("observaciones");

    public final StringPath orderApellido2 = createString("orderApellido2");

    public final DateTimePath<java.util.Date> orderLastUpdate = createDateTime("orderLastUpdate", java.util.Date.class);

    public final NumberPath<Integer> pendienteCompletar = createNumber("pendienteCompletar", Integer.class);

    public final StringPath sexo = createString("sexo");

    public final StringPath telefono = createString("telefono");

    public QJugPersona(String variable) {
        this(JugPersona.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugPersona(Path<? extends JugPersona> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugPersona(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugPersona(PathMetadata<?> metadata, PathInits inits) {
        this(JugPersona.class, metadata, inits);
    }

    public QJugPersona(Class<? extends JugPersona> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.jugProvincia = inits.isInitialized("jugProvincia") ? new QJugProvincia(forProperty("jugProvincia"), inits.get("jugProvincia")) : null;
    }

    public QJugProvincia jugProvincia() {
        if (jugProvincia == null){
            jugProvincia = new QJugProvincia(forProperty("jugProvincia"));
        }
        return jugProvincia;
    }

}

