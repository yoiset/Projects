package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTipoDocIdentidad is a Querydsl query type for TipoDocIdentidad
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoDocIdentidad extends EntityPathBase<TipoDocIdentidad> {

    private static final long serialVersionUID = -1995844452;

    public static final QTipoDocIdentidad tipoDocIdentidad = new QTipoDocIdentidad("tipoDocIdentidad");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QTipoDocIdentidad(String variable) {
        super(TipoDocIdentidad.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTipoDocIdentidad(Path<? extends TipoDocIdentidad> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTipoDocIdentidad(PathMetadata<?> metadata) {
        super(TipoDocIdentidad.class, metadata);
    }

}

