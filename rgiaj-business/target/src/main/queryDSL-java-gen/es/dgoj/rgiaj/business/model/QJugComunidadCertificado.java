package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QJugComunidadCertificado is a Querydsl query type for JugComunidadCertificado
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QJugComunidadCertificado extends EntityPathBase<JugComunidadCertificado> {

    private static final long serialVersionUID = -1240989;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QJugComunidadCertificado jugComunidadCertificado = new QJugComunidadCertificado("jugComunidadCertificado");

    public final StringPath certificado = createString("certificado");

    public final DateTimePath<java.util.Date> fechaCarga = createDateTime("fechaCarga", java.util.Date.class);

    public final DateTimePath<java.util.Date> fechaHasta = createDateTime("fechaHasta", java.util.Date.class);

    public final StringPath fingerSha1 = createString("fingerSha1");

    public final StringPath hashCertificado = createString("hashCertificado");

    protected QJugComunidadCertificadoPK id;

    public final NumberPath<Integer> indActivo = createNumber("indActivo", Integer.class);

    protected QJugComunidad jugComunidad;

    public QJugComunidadCertificado(String variable) {
        this(JugComunidadCertificado.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QJugComunidadCertificado(Path<? extends JugComunidadCertificado> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugComunidadCertificado(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QJugComunidadCertificado(PathMetadata<?> metadata, PathInits inits) {
        this(JugComunidadCertificado.class, metadata, inits);
    }

    public QJugComunidadCertificado(Class<? extends JugComunidadCertificado> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new QJugComunidadCertificadoPK(forProperty("id")) : null;
        this.jugComunidad = inits.isInitialized("jugComunidad") ? new QJugComunidad(forProperty("jugComunidad")) : null;
    }

    public QJugComunidadCertificadoPK id() {
        if (id == null){
            id = new QJugComunidadCertificadoPK(forProperty("id"));
        }
        return id;
    }

    public QJugComunidad jugComunidad() {
        if (jugComunidad == null){
            jugComunidad = new QJugComunidad(forProperty("jugComunidad"));
        }
        return jugComunidad;
    }

}

