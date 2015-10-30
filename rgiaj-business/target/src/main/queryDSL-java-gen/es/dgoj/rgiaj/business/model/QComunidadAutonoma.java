package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QComunidadAutonoma is a Querydsl query type for ComunidadAutonoma
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QComunidadAutonoma extends EntityPathBase<ComunidadAutonoma> {

    private static final long serialVersionUID = 168545226;

    public static final QComunidadAutonoma comunidadAutonoma = new QComunidadAutonoma("comunidadAutonoma");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QComunidadAutonoma(String variable) {
        super(ComunidadAutonoma.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QComunidadAutonoma(Path<? extends ComunidadAutonoma> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QComunidadAutonoma(PathMetadata<?> metadata) {
        super(ComunidadAutonoma.class, metadata);
    }

}

