package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTipoInscripcion is a Querydsl query type for TipoInscripcion
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTipoInscripcion extends EntityPathBase<TipoInscripcion> {

    private static final long serialVersionUID = 1101096515;

    public static final QTipoInscripcion tipoInscripcion = new QTipoInscripcion("tipoInscripcion");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QTipoInscripcion(String variable) {
        super(TipoInscripcion.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QTipoInscripcion(Path<? extends TipoInscripcion> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QTipoInscripcion(PathMetadata<?> metadata) {
        super(TipoInscripcion.class, metadata);
    }

}

