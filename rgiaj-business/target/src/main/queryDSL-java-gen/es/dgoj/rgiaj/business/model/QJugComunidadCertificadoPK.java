package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QJugComunidadCertificadoPK is a Querydsl query type for JugComunidadCertificadoPK
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QJugComunidadCertificadoPK extends BeanPath<JugComunidadCertificadoPK> {

    private static final long serialVersionUID = -1192587874;

    public static final QJugComunidadCertificadoPK jugComunidadCertificadoPK = new QJugComunidadCertificadoPK("jugComunidadCertificadoPK");

    public final DateTimePath<java.util.Date> fechaDesde = createDateTime("fechaDesde", java.util.Date.class);

    public final NumberPath<Long> idComunidad = createNumber("idComunidad", Long.class);

    public QJugComunidadCertificadoPK(String variable) {
        super(JugComunidadCertificadoPK.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJugComunidadCertificadoPK(Path<? extends JugComunidadCertificadoPK> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QJugComunidadCertificadoPK(PathMetadata<?> metadata) {
        super(JugComunidadCertificadoPK.class, metadata);
    }

}

