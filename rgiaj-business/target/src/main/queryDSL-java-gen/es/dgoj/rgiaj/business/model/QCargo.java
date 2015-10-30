package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCargo is a Querydsl query type for Cargo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCargo extends EntityPathBase<Cargo> {

    private static final long serialVersionUID = 884849098;

    public static final QCargo cargo = new QCargo("cargo");

    public final NumberPath<Integer> activo = createNumber("activo", Integer.class);

    public final StringPath codigo = createString("codigo");

    public final NumberPath<Integer> defecto = createNumber("defecto", Integer.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCargo(String variable) {
        super(Cargo.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QCargo(Path<? extends Cargo> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QCargo(PathMetadata<?> metadata) {
        super(Cargo.class, metadata);
    }

}

